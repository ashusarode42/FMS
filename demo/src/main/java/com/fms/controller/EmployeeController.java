package com.fms.controller;

import com.fms.entity.Employee;
import com.fms.service.EmployeeService;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// We use autowire annotation here
	@Autowired
	private EmployeeService employeeService;
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		Employee employeeResponse = employeeService.addEmployee(employee);

		logger.info("Entered the addEmployees() by using ID controller method");
		
		if (employeeResponse.equals(null)) {
			return new ResponseEntity("Sorry!Employee not inserted!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping("/employees/all")
	public List<Employee> viewAllEmpoyees() {

		// logging info about which method we have used
		logger.info("Entered the viewAllEmpoyees() by using ID controller method");

		List<Employee> employees = employeeService.viewAllEmployee();
		return employees;
	}
}