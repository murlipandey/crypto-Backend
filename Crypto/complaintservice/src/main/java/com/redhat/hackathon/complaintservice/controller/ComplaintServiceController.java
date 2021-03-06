package com.redhat.hackathon.complaintservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.hackathon.complaintservice.data.ComplaintDetail;
import com.redhat.hackathon.complaintservice.service.ComplaintService;

@RestController
@RequestMapping(value = "/complaint")
public class ComplaintServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintServiceController.class);

	@Autowired
	ComplaintService complaintService;
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> registerComplaint(@RequestBody ComplaintDetail complaintDetail) throws Throwable {

		LOGGER.trace("Start Method : registerComplaint()");

		String response = null;
		LOGGER.info("Request object for registerComplaint() : " + complaintDetail);

		try {
			response = complaintService.createComplaint(complaintDetail);
		} catch (Exception e) {
			LOGGER.error("Exception occurrred in registerComplaint() : " + e);
		}
		LOGGER.trace("End Method : registerComplaint()");

		return ResponseEntity.ok(response);

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<String> updateComplaint(@RequestBody ComplaintDetail complaintDetail) {
		LOGGER.trace("Start Method : updateComplaint()");
		String response = null;
		LOGGER.info("Request object for updateComplaint() : " + complaintDetail);
		try {
			response = complaintService.updateComplaint(complaintDetail);
		} catch (Exception e) {
			LOGGER.error("Exception occurrred in updateComplaint() : " + e);
		}
		LOGGER.trace("End Method : updateComplaint()");
		return ResponseEntity.ok(response);

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<ComplaintDetail> searchComplaint(@RequestParam("complaintId") Long complaintId) {
		LOGGER.trace("Start Method : searchComplaint()");
		ComplaintDetail response = null;
		LOGGER.info("Request parameter for updateComplaint() -> complaint id : " + complaintId);
		try {
			response = complaintService.getComplaintDetails(complaintId);
		} catch (Exception e) {
			LOGGER.error("Exception occurrred in searchComplaint() : " + e);
		}
		LOGGER.trace("End Method : searchComplaint()");
		return ResponseEntity.ok(response);

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/fetchcomplaints", method = RequestMethod.POST)
	public ResponseEntity<List<ComplaintDetail>> fetchComplaint(@RequestBody ComplaintDetail complaintDetail) {
		LOGGER.trace("Start Method : searchComplaint()");
		List<ComplaintDetail> response = new ArrayList<>();

		LOGGER.info("Request parameter for fetchComplaint() : " + complaintDetail);
		try {
			response = complaintService.fetchComplaints(complaintDetail);
		} catch (Exception e) {
			LOGGER.error("Exception occurrred in fetchComplaint() : " + e);
		}
		LOGGER.trace("End Method : fetchComplaint()");
		return ResponseEntity.ok(response);

	}

}
