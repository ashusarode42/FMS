package com.fms.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.fms.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query(value = "SELECT a FROM Feedback a where a.programParticipant.programId = :programIdVariable")
	Set<Feedback> getFeedbackByProgram(@Param("programIdVariable") int programIdVariable);

}
