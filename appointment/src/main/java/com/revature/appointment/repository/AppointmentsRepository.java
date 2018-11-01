package com.revature.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.appointment.entity.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment,Long> {
	
	Appointment findByPatientID(long patientID);
}
