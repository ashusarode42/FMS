package com.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.dao.EmployeeRepository;

import com.fms.entity.Employee;
import com.fms.exception.EmployeeNotFoundException;
import com.fms.service.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceTests {

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Mock
	EmployeeRepository employeeRepository;

	@Test
	public void addEmployeeTest() {
		Employee employee = new Employee("Alex", "123", "PARTICIPANT");

		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.addEmployee(employee));

	}

	@Test
	public void testGetAllEmployee() {
		List<Employee> allEmployee = new ArrayList<>();
		allEmployee.add(new Employee("Alex", "123", "PARTICIPANT"));
		allEmployee.add(new Employee("Maria", "123", "PARTICIPANT"));

		Mockito.when(employeeRepository.findAll()).thenReturn(allEmployee);

		assertEquals(2, employeeService.viewAllEmployee().size());

	}

	@Test
	public void viewAllEmployeeException() {
		List<Employee> allEmployee = new ArrayList<>();

		Mockito.when(employeeRepository.findAll()).thenReturn(allEmployee);

		Exception exception = assertThrows(EmployeeNotFoundException.class, () -> employeeService.viewAllEmployee());
		assertEquals("No Employee found!!", exception.getMessage());
	}
}