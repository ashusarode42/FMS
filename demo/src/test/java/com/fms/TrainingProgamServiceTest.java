package com.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fms.dao.TrainingProgramRepository;
import com.fms.entity.Employee;
import com.fms.entity.Program;
import com.fms.exception.ProgramNotFoundException;
import com.fms.service.TrainingProgramServiceImpl;

@SpringBootTest
public class TrainingProgamServiceTest {

	@InjectMocks
	TrainingProgramServiceImpl trainingProgramService;

	@Mock
	TrainingProgramRepository trainingProgramRepository;

	@Test
	public void ViewAllProgramsTest() {
		List<Program> mockPrograms = new ArrayList<>();
		mockPrograms.add(new Program());
		mockPrograms.add(new Program());

		Mockito.when(trainingProgramRepository.findAll()).thenReturn(mockPrograms);
		assertEquals(2, trainingProgramService.viewAllPrograms().size());

	}

	@Test
	public void viewAllProgramsAvailableTest() {
		List<Program> mockPrograms = new ArrayList<>();
		mockPrograms.add(new Program(LocalDate.now(), LocalDate.of(2021, 4, 24)));

		Mockito.when(trainingProgramRepository.findAll()).thenReturn(mockPrograms);
		assertEquals(1, trainingProgramService.viewAllPrograms().size());

	}

	@Test
	public void viewAllProgramsExceptionTest() {
		List<Program> mockPrograms = new ArrayList<>();
		Mockito.when(trainingProgramRepository.findAll()).thenReturn(mockPrograms);

		Exception exception = assertThrows(ProgramNotFoundException.class,
				() -> trainingProgramService.viewAllPrograms());
		assertEquals("No Program found...", exception.getMessage());
	}

	@Test
	public void viewProgramTest() {
		int id = 304;
		Program program = new Program(LocalDate.now(), LocalDate.of(2021, 4, 24));
		Mockito.when(trainingProgramRepository.findById(id)).thenReturn(Optional.of(program));
		assertEquals(program, trainingProgramService.viewProgram(304));
	}

	@Test
	public void viewAllProgramsByFacultyTest() {
		int id = 12;
		List<Program> mockPrograms = new ArrayList<>();
		mockPrograms.add(new Program(LocalDate.now(), LocalDate.of(2021, 4, 24)));
		mockPrograms.add(new Program(LocalDate.now(), LocalDate.of(2021, 4, 24)));
		Mockito.when(trainingProgramRepository.getProgramsById(id)).thenReturn(mockPrograms);
		assertEquals(2, trainingProgramService.viewAllProgramsByFaculty(12).size());
	}

	@Test
	public void viewAllProgramsByDateTest() {
		// int id = 12;
		List<Program> mockPrograms = new ArrayList<>();
		mockPrograms.add(new Program(LocalDate.now(), LocalDate.of(2021, 4, 24)));
		mockPrograms.add(new Program(LocalDate.now(), LocalDate.of(2021, 4, 24)));
		Mockito.when(trainingProgramRepository.getProgramsByDate(LocalDate.now())).thenReturn(mockPrograms);
		assertEquals(2, trainingProgramService.viewAllProgramsByDate(LocalDate.now()).size());
	}

	@Test
	public void viewParticipantListTest() {
		int id = 5001;
		Set<Employee> mockEmployees = new HashSet<>();
		mockEmployees.add(new Employee("ram", "Ram123", "PARTICIPANT"));
		mockEmployees.add(new Employee("Amit", "Amit123", "PARTICIPANT"));

		Mockito.when(trainingProgramRepository.getEmployeesByCourse(id)).thenReturn(mockEmployees);
		assertEquals(2, trainingProgramService.viewParticipantList(5001).size());
	}

	@Test
	public void createProgramTest() {
		Program program = new Program(LocalDate.now(), LocalDate.of(2021, 4, 24));

		Mockito.when(trainingProgramRepository.saveAndFlush(program)).thenReturn(program);
		assertEquals(program, trainingProgramService.createProgram(program));

	}

	@Test
	public void removeProgramTest() {
		int programId = 304;
		//Program program = new Program(LocalDate.now(), LocalDate.of(2021, 4, 24));

		trainingProgramService.removeProgram(programId);
		verify(trainingProgramRepository, times(1)).deleteById(programId);
	}

	@Test
	public void updateProgramTest() {
		Program program = new Program(LocalDate.now(), LocalDate.of(2021, 4, 24));

		when(trainingProgramRepository.saveAndFlush(program)).thenReturn(program);
		assertEquals(program, trainingProgramService.updateProgram(program));

	}

}