package com.fms.exception;

public class CourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public CourseNotFoundException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
