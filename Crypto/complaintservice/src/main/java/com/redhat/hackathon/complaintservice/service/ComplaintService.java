package com.redhat.hackathon.complaintservice.service;

import java.util.List;

import com.redhat.hackathon.complaintservice.data.ComplaintDetail;

public interface ComplaintService {

	public String createComplaint(ComplaintDetail complaintDetail);

	public String updateComplaint(ComplaintDetail complaintDetail);

	public ComplaintDetail getComplaintDetails(Long complaintId);

	public List<ComplaintDetail> fetchComplaints(ComplaintDetail complaintDetail);
}
