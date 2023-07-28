package com.fms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	@SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq", allocationSize = 1)
	@Column(name = "employee_id")
	private int employeeId;

	@NotNull
	@Size(max = 30)
	@Column(name = "employee_name")
	private String empName;

	@Size(max = 20)
	@Column(name = "employee_pass")
	private String password;

	@NotNull
	@Column(name = "role")
	private String role;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employeesSet", cascade = CascadeType.MERGE)
	private Set<Program> programs = new HashSet<>();

	public int getEmployeeId() {
		return employeeId;
	}

	public Employee() {
		super();
	}

	public Employee(@NotNull @Size(max = 30) String empName, @Size(max = 20) String password, @NotNull String role) {
		super();
		this.empName = empName;
		this.password = password;
		this.role = role;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@JsonBackReference
	public Set<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}

}
