package com.redhat.hackathon.authservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.hackathon.authservice.data.AuthDetails;
import com.redhat.hackathon.authservice.service.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	@CrossOrigin(origins = "http://localhost:4200")

	//@CrossOrigin(origins = "*")
	@RequestMapping(value = "/authenticateuser", method = RequestMethod.POST)
	public ResponseEntity<AuthDetails> authenticateUser(@RequestBody AuthDetails authDetails) throws Throwable {
		LOGGER.trace("Start Method : authenticateUser()");
		AuthDetails authDetailsTemp = null;
		
		try {
			authDetailsTemp = authService.getPassword(authDetails);
		} catch (Exception e) {
			LOGGER.error("Exception occurrred in authenticateUser() : "+e);
		}
		LOGGER.trace("End Method : authenticateUser()");
		return ResponseEntity.ok(authDetailsTemp);

	}
}
