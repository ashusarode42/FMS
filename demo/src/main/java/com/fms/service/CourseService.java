package com.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fms.entity.Course;

@Service
public interface CourseService {

	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public Course removeCourse(int courseId);

	public Course viewCourse(int courseId);

	public List<Course> viewAllCourses();

}
