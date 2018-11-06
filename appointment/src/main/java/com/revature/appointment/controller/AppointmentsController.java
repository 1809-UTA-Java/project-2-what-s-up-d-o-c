package com.revature.appointment.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentsController.class);

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
	void saveAppointment(HttpServletRequest req, HttpServletResponse resp) {

		long patientID = Long.parseLong(req.getParameter("patientID"));
		long doctorID = Long.parseLong(req.getParameter("doctorID"));
		
		logger.info(req.getParameter("timeAndDate").replace("T", " "));
		
		Timestamp timeAndDate = Timestamp.valueOf(req.getParameter("timeAndDate").replace("T", " ") + ":00");

		Appointment newApp = new Appointment(doctorID, patientID, timeAndDate);
		appointmentsComponent.saveAppointment(newApp);
		
		try {
			resp.sendRedirect("http://localhost:8020/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
