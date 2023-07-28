package com.fms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dao.TrainerManagementRepository;
import com.fms.entity.Trainer;
import com.fms.exception.TrainerNotFoundException;

@Service("trainerManagementService")
public class TrainerManagementServiceImpl implements TrainerManagementService {

	Logger logger = LoggerFactory.getLogger(TrainerManagementServiceImpl.class);

	@Autowired
	TrainerManagementRepository trainerManagementRepository;

	// this method is used to add the trainer
	@Override
	public Trainer addTrainer(Trainer trainer) {
		logger.info("Entered service addTrainer()");
		trainerManagementRepository.save(trainer);
		return trainer;
	}

	// this method is used to update the trainer
	@Override
	public Trainer updateTrainer(Trainer trainer) {
		logger.info("Entered service updateTrainer()");

		trainerManagementRepository.saveAndFlush(trainer);
		return trainer;
	}

	//this method is used to remove the trainer using the trainer id
	@Override
	public Trainer removeTrainer(int trainerId) {
		logger.info("Entered service removeTrainer()");
		trainerManagementRepository.deleteById(trainerId);
		return null;
	}

	//the method is used to view the trainer using the trainer id
	@Override
	public Trainer viewTrainer(int trainerId) {
		logger.info("Entered service viewTrainerById()");
		Optional<Trainer> trainer = trainerManagementRepository.findById(trainerId);
		if (trainer.isEmpty()) {
			throw new TrainerNotFoundException("No trainer Found for this Id!");
		}
		return trainer.get();
	}

	//the method is used to view all the trainers using the skills
	@Override
	public List<Trainer> viewAllTrainers(String skill) {
		logger.info("Entered service viewTrainerBySkill()");
		List<Trainer> trainers = trainerManagementRepository.getAllTrainersBySkill(skill);
		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("No trainers Found for this Skillset!");
		}
		return trainers;
	}

	//this method is used to view all the trainers
	@Override
	public List<Trainer> viewAllTrainers() {
		logger.info("Entered service viewAllTrainers()");
		List<Trainer> trainers = trainerManagementRepository.findAll();
		if (trainers.isEmpty()) {
			throw new TrainerNotFoundException("No trainers Found!!!");
		}
		return trainers;
	}

}