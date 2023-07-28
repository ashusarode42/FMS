package com.fms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.Feedback;
import com.fms.entity.ProgramParticipant;
import com.fms.service.ProgramParticipantService;

@RestController
@RequestMapping("/api")
public class ProgramParticipantController {

	@Autowired
	ProgramParticipantService programParticipantService;

	Logger logger = LoggerFactory.getLogger(ProgramParticipantController.class);
	
	@PutMapping("/employeeFeedback/{programParticipantId}")
	public ResponseEntity<ProgramParticipant> addFeedback(
			@PathVariable("programParticipantId") int programParticipantId, @RequestBody Feedback feedback) {
		ProgramParticipant responseProgramParticipant = programParticipantService.addFeedback(programParticipantId,
				feedback);
		
		logger.info("Entered the enroll participant by using controller method");

		if (responseProgramParticipant == null) {
			return new ResponseEntity("Feedback not done", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProgramParticipant>(responseProgramParticipant, HttpStatus.OK);
	}

}
