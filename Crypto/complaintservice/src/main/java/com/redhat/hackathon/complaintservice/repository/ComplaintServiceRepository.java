package com.redhat.hackathon.complaintservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.redhat.hackathon.complaintservice.data.ComplaintDetail;

@Repository
public interface ComplaintServiceRepository extends JpaRepository<ComplaintDetail, Long> {

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update ComplaintDetail set status=:status where complaintId=:complaintId")
	public int update(@Param("status") String status, @Param("complaintId") Long complaintId);

	@Transactional
	@Query("select complaintId,userId,status,serviceOrderNumber,description from ComplaintDetail where userId=:userId")
	public List<ComplaintDetail> fetchByUserId(@Param("userId") String userId);

}
