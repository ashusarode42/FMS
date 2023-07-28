package com.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.Course;
import com.fms.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {

	//This is a check comment
	// We use Autowire annotation here to generate the CourseService reference
	// variable using the CourseService implement
	// This is done automatically in the spring framework without creating
	@Autowired
	private CourseService courseService;

	// we use this to log what we have done inside the file
	Logger logger = LoggerFactory.getLogger(CourseController.class);

	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
		Course courseReturn = courseService.addCourse(course);

		// logging info about which method we have used
		logger.info("Entered the addCourse() controller method");

		if (courseReturn.equals(null)) {
			return new ResponseEntity("Sorry!Course not inserted!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}

	@PutMapping("/courses")
	public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course) {
		Course resultCourse = courseService.updateCourse(course);

		// logging info about which method we have used
		logger.info("Entered the updateCourse() controller method");

		if (resultCourse.equals(null)) {
			return new ResponseEntity("Sorry!Course not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Course>(resultCourse, HttpStatus.OK);
	}

	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Course> removeCourse(@Valid @PathVariable("courseId") Integer courseId) {
		Course deletedCourse = courseService.removeCourse(courseId);

		// logging info about which method we have used
		logger.info("Entered the deleteCourse() controller method");

		if (deletedCourse == null) {
			return new ResponseEntity("Course is deleted", HttpStatus.OK);
		}

		return new ResponseEntity<Course>(deletedCourse, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/courses/{courseId}")
	public Course viewCourse(@Valid @PathVariable("courseId") int courseId) {

		// logging info about which method we have used
		logger.info("Entered the viewCourse() by using ID controller method");

		Course course = courseService.viewCourse(courseId);
		return course;

	}

	@GetMapping("/courses")
	public List<Course> viewAllCourses() {

		// logging info about which method we have used
		logger.info("Entered the viewAllCourses() by using ID controller method");

		List<Course> courses = courseService.viewAllCourses();
		return courses;
	}

}
