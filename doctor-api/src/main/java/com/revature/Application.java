package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.doctors.repository.DoctorsRepository;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	DoctorsRepository doctorsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
