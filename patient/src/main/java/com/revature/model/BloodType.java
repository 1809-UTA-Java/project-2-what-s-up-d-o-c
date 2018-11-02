package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BLOOD_TYPES")
public class BloodType {
	@Id
	@Column(name="BT_ID")
	private int id;
	@Column(name="BT_BLOOD_TYPE")
	private String bloodType;

	public BloodType(int id, String bloodType) {
		super();
		this.id = id;
		this.bloodType = bloodType;
	}

	public BloodType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
}
