package com.redhat.hackathon.complaintservice.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPLAINTDETAIL")
public class ComplaintDetail {
@Id
@Column(name="COMPLAINTID")
private Long complaintId;

@Column(name="USERID")
private String userId;

@Column(name="STATUS")
private String status;

@Column(name="SERVICEORDERNUMBER")
private String serviceOrderNumber;

@Column(name="DESCRIPTION")
private String description;

public Long getComplaintId() {
	return complaintId;
}
public void setComplaintId(Long complaintId) {
	this.complaintId = complaintId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

public String getServiceOrderNumber() {
	return serviceOrderNumber;
}
public void setServiceOrderNumber(String serviceOrderNumber) {
	this.serviceOrderNumber = serviceOrderNumber;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


@Override
public String toString() {
	return "ComplaintDetail [complaintId=" + complaintId + ", userId=" + userId + ", status=" + status
			+ ", serviceOrderNumber=" + serviceOrderNumber + ", description=" + description + "]";
}

}
