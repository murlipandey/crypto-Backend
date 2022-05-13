package com.redhat.hackathon.complaintservice.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redhat.hackathon.complaintservice.dao.ComplaintServiceDao;
import com.redhat.hackathon.complaintservice.data.ComplaintDetail;
import com.redhat.hackathon.complaintservice.service.ComplaintService;
import com.redhat.hackathon.complaintservice.util.Constants;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintServiceImpl.class);
	@Autowired
	private ComplaintServiceDao complaintServiceDao;

	public String createComplaint(ComplaintDetail complaintDetail) {
		LOGGER.trace("Start Method : createComplaint()");
		Long randomLong = ThreadLocalRandom.current().nextLong(10000, 99999);

		SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_FORMAT);
		Date date = new Date();
		complaintDetail.setComplaintId(randomLong);
		complaintDetail.setServiceOrderNumber(Constants.UH + formatter.format(date));
		complaintDetail.setStatus(Constants.STATUS_NEW);

		LOGGER.trace("End Method : createComplaint()");

		return complaintServiceDao.registerNewComplaint(complaintDetail);

	}

	public String updateComplaint(ComplaintDetail complaintDetail) {
		LOGGER.trace("Start Method : updateComplaint()");
		String response;

		response = complaintServiceDao.updateExistingComplaint(complaintDetail);

		return response;

	}

	public ComplaintDetail getComplaintDetails(Long complaintId) {
		LOGGER.trace("Start Method : getComplaintDetails()");
		ComplaintDetail complaintDetail;
		complaintDetail = complaintServiceDao.fetchComplaintDetails(complaintId);

		return complaintDetail;

	}

	public List<ComplaintDetail> fetchComplaints(ComplaintDetail complaintDetail) {
		LOGGER.trace("Start Method : getComplaintDetails()");
		List<ComplaintDetail> response = null;

		response = complaintServiceDao.fetchComplaintDetailsByUserId(complaintDetail.getUserId());

		return response;

	}

}
