package com.revature.doctors.repository;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DoctorsRepositoryTest {
	@Autowired
	DoctorsRepository doctorsRepository;
	
	@Test
	public void testFindDoctorById() {
		
		//doctorsRepository.findDoctorById((long) 1);
		doctorsRepository.count();
		fail("Not yet implemented");
	}

}
