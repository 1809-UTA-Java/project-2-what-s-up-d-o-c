package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.entity.Appointment;

@Controller
public class ViewController {

	@RequestMapping("/doctorHome")
	public String doctorHome() {
		return "doctorHomeView";
	}

	@RequestMapping("/patientHome")
	public String patientHome() {
		return "patientHomeView";
	}

	@RequestMapping("/appointmentForm")
	public String appointmentForm() {
		return "createAppointment";
	}
	// @RequestMapping("/patient/{id}/viewAppointments")
	// public String patientAppointmetns(Model model, @PathVariable("id") int
	// id) {
	// // add appointment here
	// model.addAllAttributes("appointments",
	// "http://localhost:8200/appointments/get/" + id);
	// return "appointment/list";
	// }
	//
	@RequestMapping(value = "/doctor/{id}/viewAppointments", method = RequestMethod.POST)
	public void doctorAppointments(ModelMap map, @RequestBody ArrayList<Appointment> appointments,
			@PathVariable("id") int id, HttpServletResponse resp) {
		// add appointment here
		resp.setContentType("text/html");

		try {
			PrintWriter pw = resp.getWriter();
			pw.println("<html><body>");
			pw.println("<table>\n" +
					"<tr>\n" +
						"<td>Patient ID</td>\n" +
						"<td>Doctor ID</td>\n" +
						"<td>Date and Time</td>\n" +
					"</tr>\n");
			for(Appointment a: appointments) {
				pw.println("<tr>");
				pw.println("<td>" + a.getPatientID() + "</td>");
				pw.println("<td>" + a.getDoctorID() + "</td>");
				pw.println("<td>" + a.getDateAndTime() + "</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.println("</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	// @RequestMapping("/presciptions")
	// public String prescriptions(Model model) {
	// // add prescriptions here
	// model.addAllAttributes("presciptions", );
	// return
	// }
	
	@RequestMapping("writePrescription")
	public String createPrescription() {
		return "createPrescription";
	}
}
