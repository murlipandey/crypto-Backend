package com.redhat.hackathon.registration.daoimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.hackathon.registration.controller.RegistrationController;
import com.redhat.hackathon.registration.dao.RegistrationDao;
import com.redhat.hackathon.registration.repository.RegistrationRepository;

@Component
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	RegistrationRepository registrationRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationDaoImpl.class);

	public void registerUser(UserDetails userDetails) {
		
		LOGGER.trace("Start of Method: registerUser()");
		
		registrationRepository.save(userDetails);
		
		LOGGER.trace("End of Method: registerUser()");
	}

	public void deleteUser(String UserID) {

		LOGGER.trace("Start of Method: deleteUser()");
		
		registrationRepository.updateStatus(UserID);
		
		LOGGER.trace("End of Method: deleteUser()");		
	}

	public void updatePassword(String password, String emailId) {
		
		LOGGER.trace("Start of Method: updatePassword()");
		
		registrationRepository.updatePassword(password, emailId);
		
		LOGGER.trace("End of Method: updatePassword()");
		
	}
	/*
	 * public void updateStatus(String status, Long UserID ){
	 * 
	 * urbanHelperRegistrationrepo.update(status,UserID);
	 * System.out.println("Status Updated Successfully"); }
	 */
}
