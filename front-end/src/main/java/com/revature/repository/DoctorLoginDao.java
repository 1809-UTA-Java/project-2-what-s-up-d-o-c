package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.entity.DoctorLogin;

public interface DoctorLoginDao extends JpaRepository<DoctorLogin, Integer> {
	boolean existsByUsernameAndPassword(String username, String password);
	DoctorLogin findByUsername(String username);
}
