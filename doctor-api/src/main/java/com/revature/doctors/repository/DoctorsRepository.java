package com.revature.doctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.doctors.entities.Doctor;

@Repository
@Transactional
public interface DoctorsRepository extends JpaRepository<Doctor, Integer>{
	Doctor findDoctorById(Integer id);
}