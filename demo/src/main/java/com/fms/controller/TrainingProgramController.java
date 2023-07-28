package com.fms.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.Employee;
import com.fms.entity.Program;
import com.fms.service.TrainingProgramService;

@RestController
@RequestMapping("/api")
public class TrainingProgramController {

	@Autowired
	private TrainingProgramService trainingProgramService;
	
	Logger logger = LoggerFactory.getLogger(TrainingProgramController.class);


	@PutMapping("/programs")
	public ResponseEntity<Program> updateProgram(@Valid @RequestBody Program program) {
		Program programResponse = trainingProgramService.updateProgram(program);

		logger.info("Entered the update program by using controller method");
		
		if (programResponse.equals(null)) {
			return new ResponseEntity("Sorry!Program not updated!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Program>(programResponse, HttpStatus.OK);
	}

	@PostMapping("/programs")
	public ResponseEntity<Program> addProgram(@Valid @RequestBody Program program) {
		Program programResponse = trainingProgramService.createProgram(program);

		logger.info("Entered the add program by using controller method");

		
		if (programResponse.equals(null)) {
			return new ResponseEntity("Sorry!Program not inserted!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}

	@GetMapping("/programs/{programId}")
	public ResponseEntity<Program> findProgram(@Valid @PathVariable("programId") Integer programId) {

		Program program = trainingProgramService.viewProgram(programId);
		
		logger.info("Entered the find program by using controller method");


		if (program == null) {
			return new ResponseEntity("Sorry! No program found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}

	@GetMapping("/programs")
	public List<Program> viewAllProgram() {
		
		logger.info("Entered the view all program by using controller method");

		return trainingProgramService.viewAllPrograms();
	}

	@DeleteMapping("/programs/{programId}")
	public ResponseEntity<List<Program>> deleteprogram(@PathVariable("programId") Integer programId) {
		List<Program> programDelete = trainingProgramService.removeProgram(programId);
		
		logger.info("Entered the delete program by program id using controller method");
		
		if (programDelete.isEmpty() || programDelete == null) {
			return new ResponseEntity("Sorry! ProgramID not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Program>>(programDelete, HttpStatus.OK);
	}

	@GetMapping("/programsByTrainer/{trainerId}")
	public ResponseEntity<List<Program>> viewProgramsById(@PathVariable("trainerId") int trainerId) {

		List<Program> programs = trainingProgramService.viewAllProgramsByFaculty(trainerId);
		
		logger.info("Entered the view programs by id by using controller method");

		if (programs == null) {
			return new ResponseEntity("Sorry! No program found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Program>>(programs, HttpStatus.OK);
	}

	@GetMapping("/employeesByCourse/{courseId}")
	public ResponseEntity<Set<Employee>> getEmployeeByCourseId(@PathVariable("courseId") int courseId) {

		Set<Employee> empSet = trainingProgramService.viewParticipantList(courseId);
		
		logger.info("Entered the get employee by course id controller method");

		if (empSet == null) {
			return new ResponseEntity("Sorry! No program found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Set<Employee>>(empSet, HttpStatus.OK);
	}

	@GetMapping("/programsByDate/")
	List<Program> getAllInactiveUsers(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
		
		logger.info("Entered the update program by date by using controller method");
		
		return trainingProgramService.viewAllProgramsByDate(date);
	}
}