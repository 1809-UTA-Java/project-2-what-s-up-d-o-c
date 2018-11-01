package com.revature.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/get/{id}")
	Appointment getAppointment(@PathVariable ("id") long patientID) {
		return appointmentsComponent.getAppointment(patientID);
	}
}
