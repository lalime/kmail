package com.adorsys.app.data.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.MailModelRepresentation;

@Entity
public class Mail extends AbstractPersistable<Long> implements MailModelRepresentation{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1888321880636524044L;
	
	private String addressFrom  ;
	
	@ElementCollection
	private List<String> addressTo = new ArrayList<String>();
	
	private String subject ;
	
	private Date sendDate;
	
	private String contentType ;
	
	private String body ;

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
				+ ", contentType=" + contentType + ", body=" + body + "]";
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public void setBody(String body) {
		this.body = body;
	}
	
}
