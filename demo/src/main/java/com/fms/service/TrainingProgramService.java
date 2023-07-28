package com.fms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fms.entity.Employee;
import com.fms.entity.Program;

@Service
public interface TrainingProgramService {

	public Program createProgram(Program p);

	public Program updateProgram(Program p);

	public List<Program> removeProgram(Integer programId);

	public Program viewProgram(int programId);

	public List<Program> viewAllPrograms();

	public List<Program> viewAllProgramsByDate(LocalDate startdate);

	public List<Program> viewAllProgramsByFaculty(int trainerId);

	public Set<Employee> viewParticipantList(int courseId);

}