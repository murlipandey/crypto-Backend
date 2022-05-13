package com.redhat.hackathon.authservice.dao;

import com.redhat.hackathon.authservice.data.UserDetails;

public interface AuthDao {

	public UserDetails validatePassword(String userId);
}
