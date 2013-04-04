package com.adorsys.app.service.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.adorsys.app.api.data.MailModelRepresentation;

public class SimpleMailBean implements MailModelRepresentation{
	
	private String addressFrom  ;
	
	private List<String> addressTo = new ArrayList<String>();
	
	private String subject ;
	
	private Date sendDate;
	
	private String contentType ;
	
	private String body ;
	
	private Date receivedDate ;

	public String getAddressFrom() {
		return addressFrom;
	}

	public void setAddressFrom(String addressFrom) {
		this.addressFrom = addressFrom;
	}

	public List<String> getAddressTo() {
		return addressTo;
	}

	public void setAddressTo(List<String> addressTo) {
		this.addressTo = addressTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "Mail [addressFrom=" + addressFrom + ", addressTo=" + addressTo
				+ ", subject=" + subject + ", sendDate=" + sendDate
				+ ", contentType=" + contentType ;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body ;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}
	
}
