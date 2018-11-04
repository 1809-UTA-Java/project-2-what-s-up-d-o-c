package com.revature.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.appointment.repository.AppointmentsRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
		
}
