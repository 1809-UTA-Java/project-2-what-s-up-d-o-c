package com.revature.doctors.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SPECIALTIES")
public class Specialty {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Sequence")
	@SequenceGenerator(name = "S_Sequence", sequenceName = "S_Sequence")
	@Column(name = "SPECIALTY_ID")
	private Long id;
	
	@Column(name = "SPECIALTY_NAME")
	private String specialty;

	@Override
	public String toString() {
		return "Specialty [id=" + id + ", specialty=" + specialty + "]";
	}
	//API dev cycle
	//RAML

	public Specialty(Long id, String specialty) {
		super();
		this.id = id;
		this.specialty = specialty;
	}

	public Specialty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
}
