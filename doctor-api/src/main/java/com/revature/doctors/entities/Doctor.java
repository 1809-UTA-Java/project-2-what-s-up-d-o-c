package com.revature.doctors.entities;

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
@Table (name = "DOCTORS")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "D_Sequence")
	@SequenceGenerator(name = "D_Sequence", sequenceName = "D_Sequence", allocationSize=1)
	@Column(name="DOCTOR_ID")
	private Integer id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name = "DATE_OF_BIRTH")
	private Date DOB;

	@Column(name = "SPECIALTY_NAME")
	private String specialty;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String firstName, String middleName, String lastName, Date dOB, String specialty) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		DOB = dOB;
		this.specialty = specialty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
}