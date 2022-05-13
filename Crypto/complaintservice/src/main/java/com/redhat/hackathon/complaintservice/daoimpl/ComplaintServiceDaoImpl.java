package com.redhat.hackathon.complaintservice.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.hackathon.complaintservice.dao.ComplaintServiceDao;
import com.redhat.hackathon.complaintservice.data.ComplaintDetail;
import com.redhat.hackathon.complaintservice.repository.ComplaintServiceRepository;
import com.redhat.hackathon.complaintservice.util.Constants;

@Component
public class ComplaintServiceDaoImpl implements ComplaintServiceDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintServiceDaoImpl.class);
	@Autowired
	private ComplaintServiceRepository complaintServiceRepository;

	public String registerNewComplaint(ComplaintDetail complaintDetail) {

		LOGGER.trace("Start Method : registerNewComplaint()");
		String status;

		complaintServiceRepository.save(complaintDetail);
		if (complaintServiceRepository.findOne(complaintDetail.getComplaintId()) != null) {
			status = Constants.SUCCESS;
		} else {
			status = Constants.FAILED_TO_GENERATE_COMPLAINT;
		}
		LOGGER.trace("End Method : registerNewComplaint()");
		return status;
	}

	public String updateExistingComplaint(ComplaintDetail complaintDetail) {
		LOGGER.trace("Start Method : updateExistingComplaint()");
		String status = Constants.SUCCESS;

		complaintServiceRepository.update(complaintDetail.getStatus(), complaintDetail.getComplaintId());
		/*
		 * if (complaintServiceRepository.findOne(complaintDetail.getComplaintId()) !=
		 * null) { status = "SUCCESS"; } else { status = "Failed to generate complaint";
		 * }
		 */
		LOGGER.trace("End Method : updateExistingComplaint()");
		return status;
	}

	public ComplaintDetail fetchComplaintDetails(Long complaintId) {
		LOGGER.trace("Start Method : fetchComplaintDetails()");

		ComplaintDetail complaintDetail = complaintServiceRepository.findOne(complaintId);

		LOGGER.trace("End Method : fetchComplaintDetails()");
		return complaintDetail;
	}

	public List<ComplaintDetail> fetchComplaintDetailsByUserId(String userId) {
		LOGGER.trace("Start Method : fetchComplaintDetails()");
		List<ComplaintDetail> complaintDetailsList = new ArrayList<>();
		complaintDetailsList = complaintServiceRepository.fetchByUserId(userId);

		LOGGER.trace("End Method : fetchComplaintDetails()");
		return complaintDetailsList;
	}

}
