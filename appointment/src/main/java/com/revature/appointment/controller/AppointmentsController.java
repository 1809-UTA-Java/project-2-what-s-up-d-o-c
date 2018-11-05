package com.revature.appointment.controller;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.appointment.component.AppointmentsComponent;
import com.revature.appointment.entity.Appointment;

@RestController
@CrossOrigin
@RequestMapping("/appointments")
public class AppointmentsController {
	AppointmentsComponent appointmentsComponent;

	@Autowired
	AppointmentsController(AppointmentsComponent appointmentsComponent) {
		this.appointmentsComponent = appointmentsComponent;
	}

	@RequestMapping("/getPatientApps/{id}")
	ArrayList<Appointment> getAppointmentbyPatient(@PathVariable("id") long patientID) {
		return appointmentsComponent.getAppointmentbyPatient(patientID);
	}

	@RequestMapping("/getDoctorApps/{id}")
	ArrayList<Appointment> getAppointmentbyDoctor(@PathVariable("id") long doctorID) {
		return appointmentsComponent.getAppointmentbyDoctor(doctorID);
	}

	@RequestMapping(value = "/saveAppointment", method = RequestMethod.POST)
	void saveAppointment(HttpServletRequest req) {

		long patientID = Long.parseLong(req.getParameter("patientID"));
		long doctorID = Long.parseLong(req.getParameter("doctorID"));
		Timestamp timeAndDate = Timestamp.valueOf(req.getParameter("timeAndDate"));

		Appointment newApp = new Appointment(doctorID, patientID, timeAndDate);
		appointmentsComponent.saveAppointment(newApp);
	}

}
