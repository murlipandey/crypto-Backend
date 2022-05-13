package com.redhat.hackathon.registration.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.hackathon.registration.daoimpl.RegistrationDaoImpl;
import com.redhat.hackathon.registration.daoimpl.UserDetails;
import com.redhat.hackathon.registration.repository.RegistrationRepository;
import com.redhat.hackathon.registration.service.RegistrationService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationRepository registrationRepository;

	@Autowired
	RegistrationService registrationService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<String> signUp(@RequestBody UserDetails userDetails) {

		LOGGER.trace("Start of Method: signUp()");
		String signup = null;
		signup = registrationService.registerNewUser(userDetails);

		LOGGER.trace("End of Method: signUp()");
		
		return ResponseEntity.ok(signup);
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> deleteUser(@RequestBody UserDetails userDetails) {

		LOGGER.trace("Start of Method: deleteUser()");
		
		String deleteStatus = null;
		deleteStatus = registrationService.deleteRegisteredUser(userDetails);
		
		LOGGER.trace("End of Method: deleteUser()");
		return ResponseEntity.ok(deleteStatus);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ResponseEntity<String> passwordUpdate(@RequestBody UserDetails userDetails) {

		LOGGER.trace("Start of Method: passwordUpdate()");
		String passwordStatus = null;
		passwordStatus = registrationService.forgotPassword(userDetails);

		LOGGER.trace("End of Method: passwordUpdate()");
		return ResponseEntity.ok(passwordStatus);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {

		System.out.println("Hell0");

		return ResponseEntity.ok("Hello");
	}

}
