package com.redhat.hackathon.registration.dao;

import com.redhat.hackathon.registration.daoimpl.UserDetails;

public interface RegistrationDao {

	public void registerUser(UserDetails userDetails);
	
	public void deleteUser(String UserID);
	
	public void updatePassword(String password,String emailId);
}
