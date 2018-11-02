package com.revature.patient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENDERS")
public class Gender {
	@Id
	@Column(name="G_ID")
	private int id;
	@Column(name="G_GENDER")
	private String gender;

	public Gender(int id, String gender) {
		super();
		this.id = id;
		this.gender = gender;
	}

	public Gender() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
