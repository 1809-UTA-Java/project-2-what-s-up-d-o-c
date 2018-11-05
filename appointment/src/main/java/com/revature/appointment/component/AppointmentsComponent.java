package com.revature.appointment.component;

import java.util.ArrayList;

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

	public ArrayList<Appointment> getAppointmentbyPatient(long patientID) {
		return appointmentsRepository.findAllByPatientID(patientID);
	}

	public ArrayList<Appointment> getAppointmentbyDoctor(long doctorID) {
		return appointmentsRepository.findAllByDoctorID(doctorID);
	}

	public void saveAppointment(Appointment app) {
		appointmentsRepository.save(app);
	}

}
