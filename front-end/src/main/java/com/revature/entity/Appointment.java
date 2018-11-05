package com.revature.entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Appointment {

	long appointmentID;

	long patientID;
	
	long doctorID;
	
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
