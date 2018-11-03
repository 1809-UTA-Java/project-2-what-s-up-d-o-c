package com.revature.doctors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.doctors.entities.Name;

public interface NamesRepository extends JpaRepository <Name, Long>{
	
}
