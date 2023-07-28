package com.fms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dao.TrainingProgramRepository;
import com.fms.entity.Employee;
import com.fms.entity.Program;
import com.fms.exception.ProgramNotFoundException;

@Service("trainingProgramService")
public class TrainingProgramServiceImpl implements TrainingProgramService {

	@Autowired
	TrainingProgramRepository trainingProgramRepository;

	Logger logger = LoggerFactory.getLogger(ProgramNotFoundException.class);

	// this method is used to create the program
	@Override
	public Program createProgram(Program program) {

		trainingProgramRepository.saveAndFlush(program);
		return program;
	}

	//this method is used to update the program
	@Override
	public Program updateProgram(Program program) {
		return trainingProgramRepository.saveAndFlush(program);
	}

	@Override

	public List<Program> removeProgram(Integer programId) {

		trainingProgramRepository.deleteById(programId);
		return trainingProgramRepository.findAll();
	}

	
	//this method is used to view the program using the program id
	@Override
	public Program viewProgram(int programId) {

		return trainingProgramRepository.findById(programId).get();
	}

	
	// this method is used to view all the programs
	@Override
	public List<Program> viewAllPrograms() {
		logger.info("Entered service getAllPrograms");
		List<Program> allPrograms = trainingProgramRepository.findAll();
		if (allPrograms.isEmpty()) {
			throw new ProgramNotFoundException("No Program found...");
		} else
			return allPrograms;
	}

	
	// this method is used to view all the programs by date
	@Override
	public List<Program> viewAllProgramsByDate(LocalDate startdate) {

		List<Program> resultList = trainingProgramRepository.getProgramsByDate(startdate);
		return resultList;
	}

	// this method is used to view all the programs by faculty
	@Override
	public List<Program> viewAllProgramsByFaculty(int trainerId) {

		List<Program> resultList = trainingProgramRepository.getProgramsById(trainerId);
		return resultList;

	}

	
	// this method is used to view all the participant list using the course id
	@Override
	public Set<Employee> viewParticipantList(int courseId) {

		Set<Employee> empList = trainingProgramRepository.getEmployeesByCourse(courseId);

		return empList;
	}

}