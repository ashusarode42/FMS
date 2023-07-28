package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dao.ProgramParticipantRepository;
import com.fms.entity.Feedback;
import com.fms.entity.ProgramParticipant;

@Service("programParticipantService")
public class ProgramParticipantServiceImpl implements ProgramParticipantService {

	@Autowired
	ProgramParticipantRepository programParticipantRepository;

	
	//this method is used to add the participant feedback
	@Override
	public ProgramParticipant addFeedback(int programParticipantId, Feedback feedback) {

		ProgramParticipant programParticipant = programParticipantRepository.getById(programParticipantId);

		programParticipant.setFeedback(feedback);

		programParticipantRepository.saveAndFlush(programParticipant);

		return programParticipant;
	}
}
