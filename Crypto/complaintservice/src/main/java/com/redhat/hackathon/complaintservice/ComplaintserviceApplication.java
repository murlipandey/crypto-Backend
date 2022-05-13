package com.redhat.hackathon.complaintservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComplaintserviceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintserviceApplication.class);

	public static void main(String[] args) {
		LOGGER.trace("Start Method : main()");
		try {
			SpringApplication.run(ComplaintserviceApplication.class, args);
		} catch (Exception e) {
			LOGGER.error("Exception occurrred in ComplaintserviceApplication : "+e);
		}
		
		LOGGER.trace("End Method : main()");
	}

}
