package com.revature.doctors.entities;

import java.sql.Date;

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
	@SequenceGenerator(name = "D_Sequence", sequenceName = "D_Sequence")
	@Column(name="DOCTOR_ID")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "NAME")
	private Name name;
	
	@Column(name = "DATE_OF_BIRTH")
	private Date DOB;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SPECIALTY")
	private Specialty speciality;

	public Doctor(Long id, Name name, Date dOB, Specialty speciality) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
		this.speciality = speciality;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Specialty getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Specialty speciality) {
		this.speciality = speciality;
	}
	
	
}