package com.fms.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//levels of logging
//1.info 2.debug 3.trace 4.warn 5.error

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// We use logger to do logging
	// we we use org.slf4j for LoggerFactory
	// we also use org.slf4j for Logger also
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(CourseNotFoundException exception, WebRequest webRequest) {

		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(ProgramParticipantNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(ProgramParticipantNotFoundException exception,
			WebRequest webRequest) {

		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(ProgramNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(ProgramNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(FeedbackNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(TrainerNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(TrainerNotFoundException exception, WebRequest webRequest) {
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.error(ex.getMessage());
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);

		});
		ResponseEntity<Object> entity = new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		return entity;
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(EmployeeNotFoundException exception, WebRequest webRequest) {

		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

}
