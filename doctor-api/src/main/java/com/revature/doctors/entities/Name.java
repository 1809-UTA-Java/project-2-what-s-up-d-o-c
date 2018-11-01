package com.revature.doctors.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "NAMES")
public class Name {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "N_Sequence")
	@SequenceGenerator(name = "N_Sequence", sequenceName = "N_Sequence")
	@Column(name = "NAME_ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	
}
