package com.od.tcs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;

@SpringBootApplication(exclude = WebServicesAutoConfiguration.class)
public class OverDraftEligibilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverDraftEligibilityApplication.class, args);
	}

}
