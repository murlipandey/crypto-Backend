package com.redhat.hackathon.registration.service;

import com.redhat.hackathon.registration.daoimpl.UserDetails;

public interface RegistrationService {

	public String registerNewUser(UserDetails userDetails);

	public String deleteRegisteredUser(UserDetails userDetails);

	public String forgotPassword(UserDetails userDetails);

}
