package com.redhat.hackathon.authservice.service;

import com.redhat.hackathon.authservice.data.AuthDetails;

public interface AuthService {

	public AuthDetails getPassword(AuthDetails authDetails);
}
