package com.revature.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.patient.model.BloodType;

public interface BloodTypeDao extends JpaRepository<BloodType, Integer>{
	BloodType findByBloodType(String bloodType);
}
