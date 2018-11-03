package com.revature;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.doctors.entities.Doctor;
import com.revature.doctors.repository.DoctorsRepository;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	DoctorsRepository doctorsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

	@Bean
	CommandLineRunner runner(DoctorsRepository doctorsRepository) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Doctor>> typeReference = new TypeReference<List<Doctor>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/newApp.json");
			try {
				List<Doctor> apps = mapper.readValue(inputStream,typeReference);
				doctorsRepository.saveAll(apps);
				logger.info("Appointments Saved!");
			} catch (IOException e){
				logger.info("Unable to save apps: " + e.getMessage());
			}
		};
	}
	
}
