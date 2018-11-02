package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer>{
	Patient findById(int id);
}
