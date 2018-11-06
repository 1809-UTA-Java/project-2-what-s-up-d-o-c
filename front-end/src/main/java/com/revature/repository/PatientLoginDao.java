package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entity.PatientLogin;

public interface PatientLoginDao extends JpaRepository<PatientLogin, Integer>{
	boolean existsByUsernameAndPassword(String username, String password);
	PatientLogin findByUsername(String username);
}
