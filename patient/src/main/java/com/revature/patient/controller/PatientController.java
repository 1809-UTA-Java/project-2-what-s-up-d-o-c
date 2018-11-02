package com.revature.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.patient.model.Patient;
import com.revature.patient.repository.PatientDao;

@RestController
public class PatientController {

	@Autowired
	PatientDao dao;
	
	@RequestMapping("/patients")
	public List<Patient> getAll() {
		return dao.findAll(); 
	}
	
	@RequestMapping("patients/{id}")
	public Patient getById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
}
