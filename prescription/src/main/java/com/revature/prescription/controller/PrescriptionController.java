package com.revature.prescription.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.prescription.entity.Prescription;
import com.revature.prescription.repository.PrescriptionDao;

@RestController
public class PrescriptionController {

	@Autowired
	PrescriptionDao dao;
	
	@GetMapping("/prescription/Prescribed")
	public ArrayList<Prescription> getPrescribed(){
		return dao.findAllByStatus("Prescribed");
	}
	
//	@GetMapping("/prescription/{id}")
//	public Prescription getById(@PathVariable("id") long id){
//		return dao.findByPrescriptionID(id);
//	}
	
	@GetMapping("/prescription/doctor/{id}")
	public Prescription getByDoctorId(@PathVariable("id") long id){
		return dao.findByDoctorID(id);
	}
	
	@GetMapping("/prescription/patient/{id}")
	public Prescription getByPatientId(@PathVariable("id") long id){
		return dao.findByPatientID(id);
	}
	
	@ModelAttribute("/prescription/{id}/Approve")
	public boolean approvePrescription(@PathVariable("id") long id){
		Prescription found = dao.findByPrescriptionID(id);
		if (found == null)
			return false;
		else if (found.getStatus() != "Prescribed")
			return false;
		else{
			found.setStatus("Distributed");
			return true;
		}
	}
	
	@RequestMapping(value = "/prescription/new/submit", method=RequestMethod.POST)
	public void newPrescription(HttpServletRequest request){
		Prescription prescription = new Prescription();
		prescription.setDoctorID(Long.parseLong(request.getParameter("doctorID")));
		prescription.setPatientID(Long.parseLong(request.getParameter("patientID")));
		prescription.setDrugID(Long.parseLong(request.getParameter("drugID")));
		prescription.setAmmount(Long.parseLong(request.getParameter("ammount")));
		dao.save(prescription);
	}
}
