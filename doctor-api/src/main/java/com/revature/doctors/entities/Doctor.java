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
/*@SecondaryTables({
	@SecondaryTable(name="NAMES", pkJoinColumns={
			@PrimaryKeyJoinColumn(name="NAME_ID", referencedColumnName="DOCTOR_ID") }),
	@SecondaryTable(name="SPECIALTIES", pkJoinColumns={
			@PrimaryKeyJoinColumn(name="SPECIALTY_ID", referencedColumnName="DOCTOR_ID") })
	})*/
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "D_Sequence")
	@SequenceGenerator(name = "D_Sequence", sequenceName = "D_Sequence", allocationSize=1)
	@Column(name="DOCTOR_ID")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "NAME", referencedColumnName = "NAME_ID")
	//@JsonUnwrapped
	private Name name;
	
	@Column(name = "DATE_OF_BIRTH")
	private Date DOB;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name = "SPECIALTY", referencedColumnName = "SPECIALTY_ID")
	//@JsonUnwrapped
	private Specialty specialty;

	public Doctor(Name name, Date dOB, Specialty specialty) {
		super();
		this.name = name;
		DOB = dOB;
		this.specialty = specialty;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpeciality(Specialty specialty) {
		this.specialty = specialty;
	}
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", DOB=" + DOB + ", specialty=" + specialty + "]";
	}
	
}