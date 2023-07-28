package com.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fms.entity.Trainer;

@Repository
public interface TrainerManagementRepository extends JpaRepository<Trainer, Integer> {

	@Query(value = "select s from Trainer s where s.skill = :skill")
	List<Trainer> getAllTrainersBySkill(@Param("skill") String skill);

}
