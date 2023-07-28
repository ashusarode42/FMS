package com.fms.exception;

public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String msg;

	public EmployeeNotFoundException(String msg) {
		this.msg = msg;

	}

	@Override
	public String getMessage() {
		return msg;
	}

}