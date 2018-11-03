package com.revature.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.patient.model.Condition;

public interface ConditionDao extends JpaRepository<Condition, Integer>{
	Condition findByCondition(String condition);
}
