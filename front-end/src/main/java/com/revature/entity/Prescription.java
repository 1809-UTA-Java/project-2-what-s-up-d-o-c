package com.revature.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRESCRIPTIONS")
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRESCRIPTIONGEN")
	@SequenceGenerator(name = "PRESCRIPTIONGEN", sequenceName = "PRESCRIPTIONGEN", allocationSize = 1, initialValue = 1)
	@Column(name = "PRESCRIPTION_ID")
	long prescriptionID;

	@Column(name = "PATIENT_ID")
	long patientID;

	@Column(name = "DOCTOR_ID")
	long doctorID;

	@Column(name = "DRUGS_ID")
	long drugID;

	@Column(name = "AMMOUNT")
	long ammount;

	public Prescription(long patientID, long doctorID, long drugID, long ammount) {
		super();
		this.patientID = patientID;
		this.doctorID = doctorID;
		this.drugID = drugID;
		this.ammount = ammount;
	}

	public Prescription() {
		// TODO Auto-generated constructor stub
	}

	public long getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(long prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}

	public long getDrugID() {
		return drugID;
	}

	public void setDrugID(long drugID) {
		this.drugID = drugID;
	}

	public long getAmmount() {
		return ammount;
	}

	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "Prescription [prescriptionID=" + prescriptionID + ", patientID=" + patientID + ", doctorID=" + doctorID
				+ ", drugID=" + drugID + ", ammount=" + ammount + "]";
	}

}
