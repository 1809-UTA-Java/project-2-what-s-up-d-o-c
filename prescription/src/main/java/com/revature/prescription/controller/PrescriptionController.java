package com.revature.prescription.controller;

import java.util.ArrayList;

import org.hibernate.collection.internal.PersistentIdentifierBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.prescription.entity.Prescription;
import com.revature.prescription.repository.PrescriptionDao;

@RestController
public class PrescriptionController {

	@Autowired
	PrescriptionDao dao;
	
	@ModelAttribute("prescription/Prescribed")
	public ArrayList<Prescription> getPrescribed(String status){
		return dao.findAllByStatus(status);
	}
	
	@ModelAttribute("prescription/{id}")
	public Prescription getById(@PathVariable("id") long id){
		return dao.findByID(id);
	}
}
