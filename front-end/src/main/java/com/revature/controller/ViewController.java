package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.entity.Appointment;
import com.revature.entity.Prescription;
import com.revature.repository.DoctorLoginDao;
import com.revature.repository.PatientLoginDao;

@Controller
public class ViewController {

	@Autowired
	DoctorLoginDao ddao;

	@Autowired
	PatientLoginDao pdao;

	@RequestMapping("/whats-up-doc")
	public String frontPage() {
		return "loginView";
	}
	
	@RequestMapping("/doctorHome")
	public String doctorHome() {
		return "doctorHomeView";
	}

	@RequestMapping("/patientHome")
	public String patientHome() {
		return "patientHomeView";
	}
	
	@RequestMapping("/whats-up-doc/login")
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
				
		if (req.getParameter("role").contentEquals("doctor")) {
			boolean exists = ddao.existsByUsernameAndPassword(username, password);
			
			if (exists) {
				resp.setHeader("userID","" + ddao.findByUsername(username).getId());
				resp.setHeader("view","" + "doctorHomeView");
				return "redirect:http://localhost:8020";
			} else {
				return "redirect:loginView";
			}
		} else {
			boolean exists = pdao.existsByUsernameAndPassword(username, password);
			
			if (exists) {
				resp.setHeader("userID", "" + pdao.findByUsername(username).getId());
				resp.setHeader("view","" + "patientHomeView");
				return "redirect:http://localhost:8020";
			} else {
				return "redirect:loginView";
			}
		}
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
	public void doctorAppointments(@RequestBody ArrayList<Appointment> appointments, HttpServletResponse resp) {
		// add appointment here
		resp.setContentType("text/html");

		try {
			PrintWriter pw = resp.getWriter();
			pw.println("<html><body>");
			pw.println("<table>\n" + "<tr>\n" + "<td>Patient ID</td>\n" + "<td>Doctor ID</td>\n"
					+ "<td>Date and Time</td>\n" + "</tr>\n");
			for (Appointment a : appointments) {
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
	
	 @RequestMapping("/presciptions")
	 public void prescriptions(@RequestBody ArrayList<Prescription> prescriptions, HttpServletResponse resp) {
	 // add prescriptions here
		 resp.setContentType("text/html");

			try {
				PrintWriter pw = resp.getWriter();
				pw.println("<html><body>");
				pw.println("<table>\n" + "<tr>\n" + "<td>Prescription ID</td>\n" + "<td>Doctor ID</td>\n" + "<td>Patient ID</td>\n"
						+ "<td>Drugs ID</td>\n" + "<td>Amount</td>\n" + "</tr>\n");
				for (Prescription p : prescriptions) {
					pw.println("<tr>");
					pw.println("<td>" + p.getPrescriptionID() + "</td>");
					pw.println("<td>" + p.getDoctorID() + "</td>");
					pw.println("<td>" + p.getPatientID() + "</td>");
					pw.println("<td>" + p.getDrugID() + "</td>");
					pw.println("<td>" + p.getAmmount() + "</td>");
					pw.println("</tr>");
				}
				pw.println("</table>");
				pw.println("</body></html>");
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }

	@RequestMapping("/writePrescription")
	public String createPrescription() {
		return "createPrescription";
	}
}
