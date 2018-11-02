package com.revature.patient.controller;

import java.util.List;

import org.hibernate.collection.internal.PersistentIdentifierBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.patient.model.Patient;
import com.revature.patient.model.PatientForm;
import com.revature.patient.repository.BloodTypeDao;
import com.revature.patient.repository.ConditionDao;
import com.revature.patient.repository.GenderDao;
import com.revature.patient.repository.PatientDao;

@RestController
public class PatientController {

	@Autowired
	PatientDao dao;

	@Autowired
	GenderDao gdao;
	
	@Autowired
	BloodTypeDao bdao;
	
	@Autowired
	ConditionDao cdao;
	
	@RequestMapping("/patients")
	public List<Patient> getAll() {
		return dao.findAll(); 
	}
	
	@RequestMapping("patients/{id}")
	public Patient getById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
	@RequestMapping("patients/save")
	public void savePatient(@ModelAttribute("patientForm") PatientForm pf) {
		Patient patient = new Patient();	
		
		patient.setFirstName(pf.getFirstName());
		patient.setLastName(pf.getLastName());
		patient.setDob(pf.getDob());
		patient.setHeight(pf.getHeight());
		patient.setWeight(pf.getWeight());
		patient.setGender(gdao.findByGender(pf.getGender()));
		patient.setBloodType(bdao.findByBloodType(pf.getBloodType()));
		patient.setPreExistingCondition(cdao.findByCondition(pf.getPreExistingCondition()));
		
		dao.save(patient);
	}
}
