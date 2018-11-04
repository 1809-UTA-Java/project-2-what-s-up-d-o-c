package com.revature.prescription.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/prescription/{id}")
	public Prescription getById(@PathVariable("id") long id){
		return dao.findByPrescriptionID(id);
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
	
	@PostMapping("/prescription/{doctor}/{patient}/{drug}/{ammount}")
	public Prescription newPrescription(@PathVariable("doctor") long doc, @PathVariable("patient") long pat, @PathVariable("drug") long drug, @PathVariable("ammount") long ammount){
		Prescription prescription = new Prescription(doc, pat, drug, ammount);
		dao.save(prescription);
		return prescription;
	}
}
