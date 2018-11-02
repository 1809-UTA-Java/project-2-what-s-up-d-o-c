package com.revature.patient.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENTS")
public class Patient {
	@Id
	@Column(name="P_ID")
	@SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
	private int id;
	@Column(name = "P_FIRSTNAME")
	private String firstName;
	@Column(name = "P_LASTNAME")
	private String lastName;
	@Column(name = "P_DOB")
	private Date dob;
	@Column(name = "P_HEIGHT")
	private double height;
	@Column(name = "P_WEIGHT")
	private double weight;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "G_ID", referencedColumnName = "G_ID")
	private Gender gender;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BT_ID", referencedColumnName = "BT_ID")
	private BloodType bloodType;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
	private Condition preExistingCondition;

	public Patient(int id, String firstName, String lastName, Date dob, double height, double weight, Gender gender,
			BloodType bloodType, Condition preExistingCondition) {
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

	public Patient() {
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public Condition getPreExistingCondition() {
		return preExistingCondition;
	}

	public void setPreExistingCondition(Condition preExistingCondition) {
		this.preExistingCondition = preExistingCondition;
	}

}
