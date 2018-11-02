package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Patient;
import com.revature.repository.PatientDao;

@RestController
public class PatientController {

	@Autowired
	PatientDao dao;
	
	@GetMapping("/patients")
	public List<Patient> getAll() {
		return dao.findAll(); 
	}
	
	@GetMapping("/patients/{id}")
	public Patient getById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
}
