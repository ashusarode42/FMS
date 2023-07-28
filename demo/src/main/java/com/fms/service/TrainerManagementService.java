package com.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fms.entity.Trainer;

@Service
public interface TrainerManagementService {

	public Trainer addTrainer(Trainer trainer);

	public Trainer updateTrainer(Trainer trainer);

	public Trainer removeTrainer(int trainerId);

	public Trainer viewTrainer(int trainerId);

	public List<Trainer> viewAllTrainers(String skill);

	public List<Trainer> viewAllTrainers();

}
