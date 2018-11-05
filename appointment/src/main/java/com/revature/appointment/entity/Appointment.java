package com.revature.appointment.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "DOC_APPOINTMENTS")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPPK")
	@SequenceGenerator(name = "APPPK", sequenceName = "APPPK", allocationSize = 1, initialValue = 1)
	@Column(name = "APPOINTMENT_ID")
	long appointmentID;

	@Column(name = "PATIENT_ID")
	long patientID;

	@Column(name = "DOCTOR_ID")
	long doctorID;

	@Column(name = "DATEANDTIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MMM yyyy HH:mm:ss z", timezone = "GMT+8")
	Timestamp dateAndTime;

	public Appointment() {
		super();
	}

	public Appointment(long doctorID, long patientID, Timestamp dateAndTime) {
		super();
		this.doctorID = doctorID;
		this.patientID = patientID;
		this.dateAndTime = dateAndTime;
	}

	public long getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(long appointmentID) {
		this.appointmentID = appointmentID;
	}

	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentID=" + appointmentID + ", doctorID=" + doctorID + ", patientID=" + patientID
				+ ", dateAndTime=" + dateAndTime + "]";
	}

}
