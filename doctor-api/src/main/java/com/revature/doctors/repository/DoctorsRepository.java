package com.revature.doctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.doctors.entities.Doctor;

public interface DoctorsRepository extends JpaRepository<Doctor, Long>{
	Doctor findDoctorById(Long id);
}
