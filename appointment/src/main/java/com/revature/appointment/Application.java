package com.revature.appointment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.appointment.entity.Appointment;
import com.revature.appointment.repository.AppointmentsRepository;

@SpringBootApplication
public class Application {
	
	@Autowired
	AppointmentsRepository appointmentsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner(AppointmentsRepository appointmentsRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Appointment>> typeReference = new TypeReference<List<Appointment>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/newApp.json");
			try {
				List<Appointment> apps = mapper.readValue(inputStream,typeReference);
				appointmentsRepository.save(apps);
				System.out.println("Appointments Saved!");
				inputStream.close();
			} catch (IOException e){
				System.out.println("Unable to save apps: " + e.getMessage());
			}
		};
	}
	
}
