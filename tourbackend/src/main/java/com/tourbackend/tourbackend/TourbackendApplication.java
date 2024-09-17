package com.tourbackend.tourbackend;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TourbackendApplication {
	public static final org.slf4j.Logger log = LoggerFactory.getLogger(TourbackendApplication.class);

	public static void main(String[] args) {
		log.info("http://localhost:3030/api/GetPlaceDetails/Balasore");
		SpringApplication.run(TourbackendApplication.class, args);
	}
}
