package com.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.fms.entity.ProgramParticipant;

@Repository
public interface ProgramParticipantRepository extends JpaRepository<ProgramParticipant, Integer> {

}
