package com.revature.appointment.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.appointment.entity.Appointment;
import com.revature.appointment.repository.AppointmentsRepository;

@Component
public class AppointmentsComponent {

	AppointmentsRepository appointmentsRepository;
	
	public AppointmentsComponent() {
	}
	
	@Autowired
	public AppointmentsComponent(AppointmentsRepository appointmentsRepository) {
		this.appointmentsRepository = appointmentsRepository;
	}
	
	public Appointment getAppointment(long patientID) {
		return appointmentsRepository.findByPatientID(patientID);
	}
	
}
