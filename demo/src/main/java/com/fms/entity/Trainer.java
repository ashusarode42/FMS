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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "trainer")
public class Trainer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "trainer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer_seq")
	@SequenceGenerator(name = "trainer_seq", sequenceName = "trainer_seq", allocationSize = 1)
	int trainerId;

	@Column(name = "trainer_name")
	String trainerName;

	@Column(name = "skill")
	String skill;

	@OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
	private Set<Program> programs = new HashSet<>();

	Trainer() {

	}

	public Trainer(String trainerName, String skill) {
		super();
		this.trainerName = trainerName;
		this.skill = skill;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@JsonBackReference
	public Set<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}

}
