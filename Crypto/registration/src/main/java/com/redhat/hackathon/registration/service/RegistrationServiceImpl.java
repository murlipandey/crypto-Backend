package com.redhat.hackathon.registration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redhat.hackathon.registration.dao.RegistrationDao;
import com.redhat.hackathon.registration.daoimpl.RegistrationDaoImpl;
import com.redhat.hackathon.registration.daoimpl.UserDetails;
import com.redhat.hackathon.registration.repository.RegistrationRepository;
import com.redhat.hackathon.registration.util.Constants;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationRepository registrationrepo;

	@Autowired
	RegistrationDao registrationDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);
	
	public String registerNewUser(UserDetails userDetails) {

		LOGGER.trace("Start of Method: registerNewUser()");
		
		String user = null;
		if (registrationrepo.findOne(userDetails.getUserId()) != null) {
			user = Constants.USER_ALREDADY_EXISTS;
		} else {
			registrationDao.registerUser(userDetails);
			user = Constants.USER_REGISTERED_SUCCESSFULLY;
		}
		System.out.println(Constants.USER + user);
		
		LOGGER.trace("End of Method: registerNewUser()");
		return user;
	}

	public String deleteRegisteredUser(UserDetails userDetails) {

		LOGGER.trace("Start of Method: deleteRegisteredUser()");
		
		String status = null;
		UserDetails userDetailsTemp = null;

		userDetailsTemp = registrationrepo.findOne(userDetails.getUserId());

		if (userDetailsTemp != null && userDetailsTemp.getStatus().equalsIgnoreCase(Constants.PASSIVE)) {
			status = Constants.USER_DOES_NOT_EXISTS;
		}

		else if (userDetailsTemp != null) {
			registrationDao.deleteUser(userDetails.getUserId());
			status = Constants.DELETED_SUCCESSFULLY;
		}
		System.out.println("Status" + status);
		LOGGER.trace("End of Method: deleteRegisteredUser()");
		
		return status;
	}

	public String forgotPassword(UserDetails userDetails) {

		LOGGER.trace("Start of Method: forgotPassword()");
		
		String updatePassword = null;

		registrationDao.updatePassword(userDetails.getPassword(), userDetails.getEmailId());
		updatePassword = Constants.PASSWORD_UPDATED_SUCCESSFULLY;

		LOGGER.trace("End of Method: forgotPassword()");
		 
		return updatePassword;
	}
}
