package com.fms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.dao.CourseRepository;
import com.fms.entity.Course;
import com.fms.exception.CourseNotFoundException;
import com.fms.service.CourseServiceImpl;

@SpringBootTest
public class CourseServiceTests {

	@InjectMocks
	CourseServiceImpl courseService;

	@Mock
	CourseRepository courseRepository;

	@Test
	public void testGetAllCourses() {
		List<Course> allCourses = new ArrayList<>();
		allCourses.add(new Course("Java", "Full stack java development", 30));
		allCourses.add(new Course(".NET", "C# development", 60));

		Mockito.when(courseRepository.findAll()).thenReturn(allCourses);

		assertEquals(2, courseService.viewAllCourses().size());

	}

	@Test
	public void testGetAllCoursesException() {
		List<Course> allCourses = new ArrayList<>();

		Mockito.when(courseRepository.findAll()).thenReturn(allCourses);

		Exception exception = assertThrows(CourseNotFoundException.class, () -> courseService.viewAllCourses());
		assertEquals("No courses found!!", exception.getMessage());

	}

	@Test
	public void testGetCourseById() {
		int id = 101;

		Course course = new Course("Java", "Full stack java development", 30);

		Mockito.when(courseRepository.findById(id)).thenReturn(Optional.of(course));

		assertEquals(course, courseService.viewCourse(101));
	}

	@Test
	public void testGetCourseByIdException() {

		int id = 101;

		Mockito.when(courseRepository.findById(id)).thenReturn(Optional.empty());

		Exception exception = assertThrows(CourseNotFoundException.class, () -> courseService.viewCourse(id));
		assertEquals("No course found for the given ID!!", exception.getMessage());
	}

	@Test
	public void addCourseTest() {
		Course course = new Course("Java", "Full stack java development", 30);

		Mockito.when(courseRepository.save(course)).thenReturn(course);
		assertEquals(course, courseService.addCourse(course));

	}

	@Test
	public void deleteCourseByIdTest() {

		courseService.removeCourse(1);
		verify(courseRepository, times(1)).deleteById(1);
	}

	@Test
	public void updateCourseTest() {
		Course course = new Course("Java", "Full stack java development", 30);

		when(courseRepository.save(course)).thenReturn(course);
		assertEquals(course, courseService.updateCourse(course));

	}

}
