package com.fms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
	@SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_seq", allocationSize = 1)
	@Column(name = "feedback_id")
	private int feedbackId;

	@Min(value = 1, message = "Please select a value between 1 to 5")
	@Max(value = 6, message = "Please select a value between 1 to 5")
	@Column(name = "feedback1")
	private int feedbackCriteria1;

	@Min(value = 1, message = "Please select a value between 1 to 5")
	@Max(value = 6, message = "Please select a value between 1 to 5")
	@Column(name = "feedback2")
	private int feedbackCriteria2;

	@Min(value = 1, message = "Please select a value between 1 to 5")
	@Max(value = 6, message = "Please select a value between 1 to 5")
	@Column(name = "feedback3")
	private int feedbackCriteria3;

	@Min(value = 1, message = "Please select a value between 1 to 5")
	@Max(value = 6, message = "Please select a value between 1 to 5")
	@Column(name = "feedback4")
	private int feedbackCriteria4;

	@Min(value = 1, message = "Please select a value between 1 to 5")
	@Max(value = 6, message = "Please select a value between 1 to 5")
	@Column(name = "feedback5")
	private int feedbackCriteria5;

	@Column(name = "comments")
	private String comments;

	@Column(name = "suggestions")
	private String suggestions;

	@JsonBackReference
	public ProgramParticipant getProgramParticipant() {
		return programParticipant;
	}

	public void setProgramParticipant(ProgramParticipant programParticipant) {
		this.programParticipant = programParticipant;
	}

	@OneToOne(mappedBy = "feedback")
	// @OneToOne(cascade = CascadeType.ALL)
	ProgramParticipant programParticipant;

	public Feedback() {

	}

	public Feedback(int feedbackCriteria1, int feedbackCriteria2, int feedbackCriteria3, int feedbackCriteria4,
			int feedbackCriteria5, String comments, String suggestions) {
		super();
		this.feedbackCriteria1 = feedbackCriteria1;
		this.feedbackCriteria2 = feedbackCriteria2;
		this.feedbackCriteria3 = feedbackCriteria3;
		this.feedbackCriteria4 = feedbackCriteria4;
		this.feedbackCriteria5 = feedbackCriteria5;
		this.comments = comments;
		this.suggestions = suggestions;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public int getFeedbackCriteria1() {
		return feedbackCriteria1;
	}

	public void setFeedbackCriteria1(int feedbackCriteria1) {
		this.feedbackCriteria1 = feedbackCriteria1;
	}

	public int getFeedbackCriteria2() {
		return feedbackCriteria2;
	}

	public void setFeedbackCriteria2(int feedbackCriteria2) {
		this.feedbackCriteria2 = feedbackCriteria2;
	}

	public int getFeedbackCriteria3() {
		return feedbackCriteria3;
	}

	public void setFeedbackCriteria3(int feedbackCriteria3) {
		this.feedbackCriteria3 = feedbackCriteria3;
	}

	public int getFeedbackCriteria4() {
		return feedbackCriteria4;
	}

	public void setFeedbackCriteria4(int feedbackCriteria4) {
		this.feedbackCriteria4 = feedbackCriteria4;
	}

	public int getFeedbackCriteria5() {
		return feedbackCriteria5;
	}

	public void setFeedbackCriteria5(int feedbackCriteria5) {
		this.feedbackCriteria5 = feedbackCriteria5;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

}