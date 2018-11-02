package com.revature.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.patient.model.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Integer>{
	Patient findById(int id);
}
