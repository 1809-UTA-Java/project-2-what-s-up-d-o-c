package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.doctors.component.DoctorsComponent;
import com.revature.doctors.entities.Doctor;

@RestController
@CrossOrigin
@RequestMapping("/doctor")
public class DoctorsController {
	DoctorsComponent doctorsComponent;
	
	@Autowired
	DoctorsController(DoctorsComponent doctorsComponent){
	 this.doctorsComponent = doctorsComponent;
	}

	@GetMapping()
	Doctor getDoctor(@RequestParam(value="doctor") Integer doctorId){
		return doctorsComponent.getDoctor(doctorId);
	}
}
