package com.revature.Drugs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DRUGS")
public class Drugs {

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "drugs_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	int id;

	String name;
	String description;
	int inventory;

	public Drugs(int id, String name, String description, int inventory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.inventory = inventory;
	}

	public Drugs() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

}
