package com.revature.doctors.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.doctors.entities.Doctor;
import com.revature.doctors.repository.DoctorsRepository;

@Component
public class DoctorsComponent {
	private static final Logger logger = LoggerFactory.getLogger(DoctorsComponent.class);

	DoctorsRepository doctorsRepository;

	public DoctorsComponent(){}

	@Autowired
	public DoctorsComponent(DoctorsRepository doctorsRepository){
			this.doctorsRepository = doctorsRepository;
		}

	public Doctor getDoctor(Long doctorId) {
		logger.info("Looking for doctor id: " + doctorId);
		return doctorsRepository.findDoctorById(doctorId);
	}
}
