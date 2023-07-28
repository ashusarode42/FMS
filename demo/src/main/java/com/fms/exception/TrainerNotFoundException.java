package com.fms.exception;

public class TrainerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public TrainerNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}