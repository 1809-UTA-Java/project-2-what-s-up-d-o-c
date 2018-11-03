package com.revature.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.patient.model.Gender;

public interface GenderDao extends JpaRepository<Gender, Integer>{
	Gender findByGender(String gender);
}
