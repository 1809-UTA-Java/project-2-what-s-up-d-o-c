package com.revature.patient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONDITIONS")
public class Condition {
	@Id
	@Column(name = "C_ID")
	private int id;
	@Column(name = "C_CONDITION")
	private String condition;

	public Condition(int id, String condition) {
		super();
		this.id = id;
		this.condition = condition;
	}

	public Condition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
