package com.fms.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "program_participant")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ProgramParticipant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "participant_id")
	int participantId;

	@Column(name = "program_id")
	int programId;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "feedback_id")
	Feedback feedback;

	public ProgramParticipant(int participantId, int programId) {
		super();

		this.participantId = participantId;
		this.programId = programId;
	}

	public ProgramParticipant() {
		super();
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "ProgramParticipant [participantId=" + participantId + ", programId=" + programId + ", feedback="
				+ feedback + "]";
	}

}
