package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientLoginDao extends JpaRepository<PatientLoginDao, Integer>{
	boolean existsByUsernameAndPassword(String username, String password);
}
