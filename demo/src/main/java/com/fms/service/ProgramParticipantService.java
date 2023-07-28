package com.fms.service;

import org.springframework.stereotype.Service;

import com.fms.entity.Feedback;
import com.fms.entity.ProgramParticipant;

@Service("programService")
public interface ProgramParticipantService {

	public ProgramParticipant addFeedback(int programParticipantId, Feedback feedback);
	
}
