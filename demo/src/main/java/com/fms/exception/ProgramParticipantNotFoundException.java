package com.fms.exception;

public class ProgramParticipantNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;

	public ProgramParticipantNotFoundException(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}
}
