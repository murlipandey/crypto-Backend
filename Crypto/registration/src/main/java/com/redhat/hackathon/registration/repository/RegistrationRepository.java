package com.redhat.hackathon.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redhat.hackathon.registration.daoimpl.UserDetails;

@Repository
public interface RegistrationRepository extends JpaRepository<UserDetails,String>{


	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update UserDetails set status='Passive' where userId=:userId")
	public int updateStatus(@Param("userId") String userId);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query("update UserDetails set password=:password where emailId=:emailId")
	public int updatePassword(@Param("password") String password,@Param("emailId") String emailId);
	
}
