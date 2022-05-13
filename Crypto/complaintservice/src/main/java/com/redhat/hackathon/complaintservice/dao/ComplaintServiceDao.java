package com.redhat.hackathon.complaintservice.dao;

import java.util.List;

import com.redhat.hackathon.complaintservice.data.ComplaintDetail;

public interface ComplaintServiceDao {

	public String registerNewComplaint(ComplaintDetail complaintDetail);

	public String updateExistingComplaint(ComplaintDetail complaintDetail);

	public ComplaintDetail fetchComplaintDetails(Long complaintId);

	public List<ComplaintDetail> fetchComplaintDetailsByUserId(String userId);
}
