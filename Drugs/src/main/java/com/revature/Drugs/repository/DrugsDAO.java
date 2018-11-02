package com.revature.Drugs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.Drugs.model.Drugs;

public interface DrugsDAO extends JpaRepository<Drugs, String>{

	Drugs findByName(String name);
	
	Drugs findById(int id);
	
	List<Drugs> findAll();
	
	<S extends Drugs>S save(Drugs d);
	
}
