/**
 * 
 */
package com.adorsys.app.api.data;

import java.util.Date;
import java.util.List;

/**
 * @author w2b
 * 
 */
public interface MailModelRepresentation {
	
	public String getAddressFrom();
	
	public void setAddressFrom(String address);
	
	public List<String> getAddressTo();
	
	public void setAddressTo(List<String> address);
	
	public String getSubject();
	
	public void setSubject(String subject);
	
	public Date getSendDate();
	
	public void setSendDate(Date sendDate);
	
	public String getContentType();
	
	public void setContentType(String contentType);
	
	public String getBody();
	
	public void setBody(String body);
	
	public Date getReceivedDate();
	
	public void setReceivedDate(Date date);
}
