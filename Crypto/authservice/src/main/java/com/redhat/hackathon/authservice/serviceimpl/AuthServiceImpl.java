package com.redhat.hackathon.authservice.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redhat.hackathon.authservice.dao.AuthDao;
import com.redhat.hackathon.authservice.data.AuthDetails;
import com.redhat.hackathon.authservice.data.UserDetails;
import com.redhat.hackathon.authservice.service.AuthService;
import com.redhat.hackathon.authservice.util.Constants;

@Service
public class AuthServiceImpl implements AuthService{
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	private AuthDao authDao;

	public AuthDetails getPassword(AuthDetails authDetails) {
		
		LOGGER.trace("Start Method : getPassword()");
		UserDetails userDetails;
		AuthDetails authReply = new AuthDetails();

		userDetails = authDao.validatePassword(authDetails.getUserId());
		authReply.setUserId(authDetails.getUserId());

		if ((userDetails == null) || (userDetails != null && Constants.PASSIVE.equalsIgnoreCase(userDetails.getStatus()))) {
			authReply.setMessage(Constants.USER_DOES_NOT_EXISTS);
		} else if (userDetails != null && authDetails.getPassword().equalsIgnoreCase(userDetails.getPassword())) {
			authReply.setPassword(userDetails.getPassword());
			authReply.setMessage(Constants.LOGIN_SUCCESSFUL);

		} else {
			authReply.setMessage(Constants.INCORRECT_PASSWORD);
		}
		LOGGER.trace("End Method : getPassword()");
		return authReply;

	}
}
