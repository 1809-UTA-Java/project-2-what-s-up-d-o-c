package com.revature.prescription.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.prescription.entity.Prescription;

@Repository
public interface PrescriptionDao extends JpaRepository<Prescription,Long> {

	Prescription findByPrescriptionID(long prescriptionID);
	
	List<Prescription> findByDoctorID(long doctorID);

	List<Prescription> findByPatientID(long patientID);
}
