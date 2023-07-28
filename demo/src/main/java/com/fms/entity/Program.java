package com.fms.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "program")
public class Program implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_seq")
	@SequenceGenerator(name = "program_seq", sequenceName = "program_seq", allocationSize = 1)
	@Column(name = "program_id")
	private int programId;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "start_date")
	private LocalDate startDate;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "end_date")
	private LocalDate endDate;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "program_participant", joinColumns = { @JoinColumn(name = "program_id") }, inverseJoinColumns = {
			@JoinColumn(name = "participant_id") })
	private Set<Employee> employeesSet = new HashSet<>();

	public Program() {

	}

	public Program(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;

	}

	public Program(LocalDate startDate, LocalDate endDate, int trainerId) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;

	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	// @JsonBackReference
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	// @JsonBackReference
	public Set<Employee> getEmployeesSet() {
		return employeesSet;
	}

	public void setEmployeesSet(Set<Employee> employeesSet) {
		this.employeesSet = employeesSet;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	// @JsonBackReference
	public Trainer getTrainer() {
		return trainer;
	}

}
