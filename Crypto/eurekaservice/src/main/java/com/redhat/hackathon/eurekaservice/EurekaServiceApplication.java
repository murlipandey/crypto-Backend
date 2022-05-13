package com.redhat.hackathon.eurekaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaServiceApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(EurekaServiceApplication.class, args);
		} catch (Exception e) {
			LOGGER.error("Exception occurrred in main() : "+e);
		}
	}

}
