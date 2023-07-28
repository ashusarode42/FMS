package com.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.Trainer;
import com.fms.service.TrainerManagementService;

@RestController
@RequestMapping("/api")
public class TrainerManagementController {

	Logger logger = LoggerFactory.getLogger(TrainerManagementController.class);

	@Autowired
	TrainerManagementService trainerManagementService;

	// Add new trainer
	@PostMapping("/trainer")
	public ResponseEntity<Trainer> insertTrainer(@Valid @RequestBody Trainer trainer) {
		logger.info("Entered insertTrainer()");
		Trainer trainer1 = trainerManagementService.addTrainer(trainer);

		if (trainer1 == null) {
			return new ResponseEntity("No trainer Available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trainer>(trainer1, HttpStatus.OK);
	}

	// Update Existing Trainer
	@PutMapping("/trainer")
	public ResponseEntity<Trainer> updateTrainer(@Valid @RequestBody Trainer trainer) {
		logger.info("Entered updatetTrainer()");
		Trainer trainer1 = trainerManagementService.updateTrainer(trainer);

		if (trainer1 == null) {
			return new ResponseEntity("No trainer Available", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trainer>(trainer1, HttpStatus.OK);
	}

	// Remove Trainer
	@DeleteMapping("/trainer/{trainerId}")
	public ResponseEntity<Trainer> deleteTrainer(@Valid @PathVariable("trainerId") Integer trainerId) {
		logger.info("Entered remveTrainer()");
		Trainer trainer1 = trainerManagementService.removeTrainer(trainerId);

		if (trainer1 == null) {
			return new ResponseEntity("Successfully deleted trainer", HttpStatus.OK);
		}
		return new ResponseEntity<Trainer>(trainer1, HttpStatus.NOT_FOUND);
	}

	// View trainer
	@GetMapping("/trainer/{trainerId}")
	public ResponseEntity<Trainer> findTrainer(@Valid @PathVariable("trainerId") Integer trainerId) {
		logger.info("Entered viewTrainer()");
		Trainer trainer1 = trainerManagementService.viewTrainer(trainerId);
		if (trainer1 == null) {
			return new ResponseEntity("Sorry! No trainer found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Trainer>(trainer1, HttpStatus.OK);
	}

	// view trainers by skill
	@GetMapping("trainers/{skill}")
	public ResponseEntity<List<Trainer>> findTrainerBySkill(@Valid @PathVariable("skill") String skill) {
		logger.info("Entered viewTrainerBySkill()");
		List<Trainer> trainers = trainerManagementService.viewAllTrainers(skill);

		if (trainers.isEmpty()) {
			return new ResponseEntity("Sorry! No trainer found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
	}

	// view all trainers
	@GetMapping("/trainer")
	public ResponseEntity<List<Trainer>> getAllTrainers() {
		logger.info("Entered viewAllTrainer()");
		List<Trainer> trainers = trainerManagementService.viewAllTrainers();
		if (trainers.isEmpty()) {
			return new ResponseEntity("Sorry! Trainers not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
	}
}