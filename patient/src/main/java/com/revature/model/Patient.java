package com.revature.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PATIENTS")
public class Patient {
	@Id
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
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "G_ID", referencedColumnName = "G_ID")
	private Gender gender;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "BT_ID", referencedColumnName = "BT_ID")
	private BloodType bloodType;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "C_ID", referencedColumnName = "C_ID")
	private List<String> preExistingConditions;


	
}
