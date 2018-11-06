package com.revature.prescription.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.prescription.entity.Prescription;
import com.revature.prescription.repository.PrescriptionDao;

@RestController
public class PrescriptionController {

	@Autowired
	PrescriptionDao dao;

	@GetMapping("/prescription/id/{id}")
	public Prescription getPrescription(@PathVariable("id") long id) {
		return dao.findByPrescriptionID(id);
	}

	@GetMapping("/prescription/doctor/{id}")
	public List<Prescription> getByDoctorId(@PathVariable("id") long id) {
		return dao.findByDoctorID(id);
	}

	@GetMapping("/prescription/patient/{id}")
	public List<Prescription> getByPatientId(@PathVariable("id") long id) {
		return dao.findByPatientID(id);
	}

	@RequestMapping("/prescription/new/submit")
	public void newPrescription(HttpServletRequest request) {
		Prescription prescription = new Prescription();
		prescription.setDoctorID(Long.parseLong(request.getParameter("doctorID")));
		prescription.setPatientID(Long.parseLong(request.getParameter("patientID")));
		prescription.setDrugID(Long.parseLong(request.getParameter("drugID")));
		prescription.setAmmount(Long.parseLong(request.getParameter("ammount")));
		dao.save(prescription);
	}
}
