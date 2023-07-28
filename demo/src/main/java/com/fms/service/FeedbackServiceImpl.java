package com.fms.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dao.FeedbackRepository;
import com.fms.entity.Feedback;
import com.fms.exception.FeedbackNotFoundException;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);

	@Autowired
	FeedbackRepository feedbackRepository;

	
	//this method is used to view all the feedbacks
	@Override
	public List<Feedback> viewAllFeedback() {
		logger.info("Entered service viewAllFeedback");
		List<Feedback> allFeedbacks = feedbackRepository.findAll();

		if (allFeedbacks.isEmpty()) {
			throw new FeedbackNotFoundException("No Feedback Found!");
		}
		return allFeedbacks;
	}

	// this method is used to add the feedback 
	@Override
	public Feedback addFeedback(Feedback feedback) {
		logger.info("Entered service addFeedback");
		feedbackRepository.save(feedback);
		return feedback;
	}

	//this method is used to view program feedback using the program id
	@Override
	public Set<Feedback> viewProgramFeedback(int programId) {
		logger.info("Entered service viewProgramFeedback");
		return feedbackRepository.getFeedbackByProgram(programId);
	}

}