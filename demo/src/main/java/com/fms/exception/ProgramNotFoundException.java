package com.fms.exception;

public class ProgramNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public ProgramNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}