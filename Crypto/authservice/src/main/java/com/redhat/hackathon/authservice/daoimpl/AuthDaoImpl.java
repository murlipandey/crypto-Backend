package com.redhat.hackathon.authservice.daoimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.hackathon.authservice.dao.AuthDao;
import com.redhat.hackathon.authservice.data.UserDetails;
import com.redhat.hackathon.authservice.repository.UserDetailsRepository;

@Component
public class AuthDaoImpl implements AuthDao{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthDaoImpl.class);

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	public UserDetails validatePassword(String userId) {
		LOGGER.trace("Start Method : validatePassword()");
		UserDetails userDetails = null;
		
		userDetails=userDetailsRepository.findOne(userId);
		
		LOGGER.trace("End Method : validatePassword()");
		
		return userDetails;
	}
	
}
