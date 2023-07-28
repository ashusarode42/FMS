package com.fms.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fms.entity.Employee;
import com.fms.entity.Program;

@Repository
public interface TrainingProgramRepository extends JpaRepository<Program, Integer> {

	@Query(value = "SELECT a FROM Program a where a.trainer.trainerId = :trainerIdVariable")
	List<Program> getProgramsById(@Param("trainerIdVariable") int trainerIdVariable);

	@Query(value = "SELECT employeesSet FROM Program a where a.course.courseId = :courseId")
	Set<Employee> getEmployeesByCourse(@Param("courseId") int courseId);

	@Query(value = "SELECT a FROM Program a where a.startDate = :date")
	List<Program> getProgramsByDate(@Param("date") LocalDate date);

}
