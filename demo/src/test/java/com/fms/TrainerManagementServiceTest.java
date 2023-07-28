package com.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fms.dao.TrainerManagementRepository;
import com.fms.entity.Trainer;
import com.fms.exception.TrainerNotFoundException;
import com.fms.service.TrainerManagementServiceImpl;

@SpringBootTest
public class TrainerManagementServiceTest {
	@Autowired
	private TrainerManagementServiceImpl trainerManagementService;

	@MockBean
	private TrainerManagementRepository trainerManagementRepository;

	@Test
	public void viewAllTrainersTest() {
		List<Trainer> allTrainers = new ArrayList<>();
		allTrainers.add(new Trainer("John Doe", "JAVA"));
		allTrainers.add(new Trainer("Rohan Jha", "Python"));

		Mockito.when(trainerManagementRepository.findAll()).thenReturn(allTrainers);
		assertEquals(2, trainerManagementService.viewAllTrainers().size());
	}

	@Test
	public void viewAllTrainersException() {
		List<Trainer> allTrainers = new ArrayList<>();

		Mockito.when(trainerManagementRepository.findAll()).thenReturn(allTrainers);

		Exception exception = assertThrows(TrainerNotFoundException.class,
				() -> trainerManagementService.viewAllTrainers());
		assertEquals("No trainers Found!!!", exception.getMessage());
	}

	@Test
	public void viewTrainerByIdTest() {
		int id = 11;
		Trainer trainer = new Trainer("John Doe", "JAVA");
		Mockito.when(trainerManagementRepository.findById(id)).thenReturn(Optional.of(trainer));
		assertEquals(trainer, trainerManagementService.viewTrainer(11));
	}

	@Test
	public void viewTrainerByIdException() {
		int id = 11;
		Mockito.when(trainerManagementRepository.findById(id)).thenReturn(Optional.empty());

		Exception exception = assertThrows(TrainerNotFoundException.class,
				() -> trainerManagementService.viewTrainer(id));
		assertEquals("No trainer Found for this Id!", exception.getMessage());
	}

	@Test
	public void viewTrainerBySkillTest() {
		String skill = "JAVA";
		List<Trainer> allTrainerBySkill = new ArrayList<>();
		allTrainerBySkill.add(new Trainer("John Doe", "JAVA"));
		allTrainerBySkill.add(new Trainer("Rohan Jha", "Python"));

		Mockito.when(trainerManagementRepository.getAllTrainersBySkill(skill)).thenReturn(allTrainerBySkill);
		assertEquals(allTrainerBySkill, trainerManagementService.viewAllTrainers(skill));

	}

	@Test
	public void viewTrainerBySkillException() {
		List<Trainer> allTrainerBySkill = new ArrayList<>();
		String skill = "JAVA";
		Mockito.when(trainerManagementRepository.getAllTrainersBySkill(skill)).thenReturn(allTrainerBySkill);

		Exception exception = assertThrows(TrainerNotFoundException.class,
				() -> trainerManagementService.viewAllTrainers(skill));
		assertEquals("No trainers Found for this Skillset!", exception.getMessage());
	}

	@Test
	public void addTrainerTest() {
		Trainer addTrainer = new Trainer("John Doe", "JAVA");
		Mockito.when(trainerManagementRepository.save(addTrainer)).thenReturn(addTrainer);
		assertEquals(addTrainer, trainerManagementService.addTrainer(addTrainer));
	}

	@Test
	public void removeTrainerTest() {
		// Trainer removeTrainer = new Trainer("John Doe", "JAVA");
		int id = 11;
		trainerManagementService.removeTrainer(id);
		verify(trainerManagementRepository, times(1)).deleteById(id);
	}

	@Test
	public void updateTrainerTest() {
		Trainer updateTrainer = new Trainer("John Doe", "JAVA");
		Mockito.when(trainerManagementRepository.save(updateTrainer)).thenReturn(updateTrainer);
		assertEquals(updateTrainer, trainerManagementService.updateTrainer(updateTrainer));
	}

}