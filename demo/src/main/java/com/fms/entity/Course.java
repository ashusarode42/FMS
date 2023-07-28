package com.fms.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
	@Column(name = "course_id")
	private int courseId;

	@NotNull
	@Size(min = 3, message = "Course Name should be greater than 3 characters!!")
	@Column(name = "course_name")
	private String courseName;

	@NotNull
	@Size(min = 3, max = 30, message = "Course desc should not exceed 30 characters!!")
	@Column(name = "course_desc")
	private String courseDescription;

	@Column(name = "no_of_days")
	private int noOfDays;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<Program> programs = new HashSet<>();

	// Default constructor for the Course class
	public Course() {

	}

	public int getCourseId() {
		return courseId;
	}

	// Parameterized constructor for the Course class
	public Course(String courseName, String courseDescription, int noOfDays) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.noOfDays = noOfDays;
	}

	// Getters and setters

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	// We use the JsonBackReference here to prevent recursion of the entity in the
	// response JSON
	@JsonBackReference
	public Set<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
}
