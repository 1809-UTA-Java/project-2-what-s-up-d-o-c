package com.revature.prescription.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.prescription.entity.Prescription;

@Repository
public interface PrescriptionDao extends JpaRepository<Prescription,Long> {

	Prescription findByID(long ID);
	
	ArrayList<Prescription> findAllByStatus(String status);
}
