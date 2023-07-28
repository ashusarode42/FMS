package com.fms.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dao.EmployeeRepository;
import com.fms.entity.Employee;
import com.fms.exception.EmployeeNotFoundException;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	// this method is used to add the employees
	@Override
	public Employee addEmployee(Employee employee) {
		
		logger.info("Entered the addEmployee() method in the service layer");

		employeeRepository.saveAndFlush(employee);

		return employee;
	}

	
	//this method is used to list all the employees
	@Override
	public List<Employee> viewAllEmployee() {
		
		logger.info("Entered the viewAllEmployee() method in the service layer");

		List<Employee> allEmployee = employeeRepository.findAll();

		if (allEmployee.isEmpty()) {
			throw new EmployeeNotFoundException("No Employee found!!");
		}

		return allEmployee;
	}

}