package com.fms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dao.CourseRepository;
import com.fms.entity.Course;
import com.fms.exception.CourseNotFoundException;

// We implement the CourseService interface
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	// We use Logger from the org.slf4j package
	// It is used to do logging
	Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	// This method is used to add the course
	@Override
	public Course addCourse(Course course) {

		// logging info about which method we have used
		logger.info("Entered the addCourse() method in the service layer");

		courseRepository.saveAndFlush(course);
		return course;
	}

	// This method is used to update the course
	@Override
	public Course updateCourse(Course course) {

		// logging info about which method we have used
		logger.info("Entered the updateCourse() method in the service layer");

		courseRepository.save(course);
		return course;
	}

	// This method is used to remove the course with the given course ID
	@Override
	public Course removeCourse(int courseId) {

		// logging info about which method we have used
		logger.info("Entered the removeCourse() method in the service layer");

		courseRepository.deleteById(courseId);
		return null;
	}

	// This method is used to display the course with the given course ID
	@Override
	public Course viewCourse(int courseId) {

		// logging info about which method we have used
		logger.info("Entered the viewCourse() by ID method in the service layer");

		Optional<Course> course = courseRepository.findById(courseId);

		if (!course.isPresent()) {
			throw new CourseNotFoundException("No course found for the given ID!!");
		}

		return course.get();
	}

	// This method is used to display all the courses which are being present
	@Override
	public List<Course> viewAllCourses() {

		// logging info about which method we have used
		logger.info("Entered the viewAllCourses method in the service layer");

		List<Course> allCourses = courseRepository.findAll();

		if (allCourses.isEmpty()) {
			throw new CourseNotFoundException("No courses found!!");
		}

		return allCourses;
	}

}
