package com.revature.patient.model;

import java.sql.Date;

public class PatientForm {
	private int id;
	private String firstName;
	private String lastName;
	private Date dob;
	private double height;
	private double weight;
	private String gender;
	private String bloodType;
	private String preExistingCondition;

	public PatientForm(int id, String firstName, String lastName, Date dob, double height, double weight, String gender,
			String bloodType, String preExistingCondition) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.bloodType = bloodType;
		this.preExistingCondition = preExistingCondition;
	}

	public PatientForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getPreExistingCondition() {
		return preExistingCondition;
	}

	public void setPreExistingCondition(String preExistingCondition) {
		this.preExistingCondition = preExistingCondition;
	}
}
