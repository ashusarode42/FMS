package com.fms.exception;

public class FeedbackNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public FeedbackNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}