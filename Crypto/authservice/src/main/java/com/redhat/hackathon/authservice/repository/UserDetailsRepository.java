package com.redhat.hackathon.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redhat.hackathon.authservice.data.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String>{

}
