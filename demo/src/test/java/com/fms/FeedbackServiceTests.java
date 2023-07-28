package com.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.dao.FeedbackRepository;
import com.fms.entity.Feedback;
import com.fms.exception.FeedbackNotFoundException;
import com.fms.service.FeedbackServiceImpl;

@SpringBootTest
public class FeedbackServiceTests {

	@InjectMocks
	FeedbackServiceImpl feedbackService;

	@Mock
	FeedbackRepository feedbackRepository;

//Tests for View all Feedbacks.	
	@Test
	public void viewAllFeedbackTest() {
		List<Feedback> allFeedbacks = new ArrayList<>();
		allFeedbacks.add(new Feedback(5, 4, 4, 5, 5, "Good", "Nice course"));
		allFeedbacks.add(new Feedback(4, 4, 3, 5, 5, "Nice one", "Liked course"));

		Mockito.when(feedbackRepository.findAll()).thenReturn(allFeedbacks);

		assertEquals(2, feedbackService.viewAllFeedback().size());
	}

	@Test
	public void getAllFeedbacksExceptionTest() {
		List<Feedback> allFeedbacks = new ArrayList<>();

		Mockito.when(feedbackRepository.findAll()).thenReturn(allFeedbacks);

		Exception exception = assertThrows(FeedbackNotFoundException.class, () -> feedbackService.viewAllFeedback());
		assertEquals("No Feedback Found!", exception.getMessage());
	}

	// Tests for addFeedback
	@Test
	public void addFeedbackTest() {
		Feedback feedback = new Feedback(5, 4, 4, 5, 5, "Good", "Nice course");
		Mockito.when(feedbackRepository.save(feedback)).thenReturn(feedback);
		assertEquals(feedback, feedbackService.addFeedback(feedback));
	}

	// Tests for viewProgramFeedback
	@Test
	public void viewProgramFeedbackTest() {
		Set<Feedback> allFeedbacks = new HashSet<>();
		allFeedbacks.add(new Feedback(5, 4, 4, 5, 5, "Good", "Nice course"));
		allFeedbacks.add(new Feedback(4, 4, 3, 5, 5, "Nice one", "Liked course"));

		Mockito.when(feedbackRepository.getFeedbackByProgram(1)).thenReturn(allFeedbacks);

		assertEquals(2, feedbackService.viewProgramFeedback(1).size());
	}

	@Test
	public void viewProgramFeedbackExceptionTest() {
		Set<Feedback> allFeedbacks = new HashSet<>();

		Mockito.when(feedbackRepository.getFeedbackByProgram(1)).thenReturn(allFeedbacks);

		Exception exception = assertThrows(FeedbackNotFoundException.class, () -> feedbackService.viewAllFeedback());
		assertEquals("No Feedback Found!", exception.getMessage());
	}

}