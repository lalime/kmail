/**
 * 
 */
package com.adorsys.app.api.data;

/**
 * @author w2b
 *
 */
public interface MailServerModelRepresentation {

	public String getHostName();
	
	public void setHostName(String hostName);
	
	public String getSendingPort() ;
	
	public void setSendingPort(String port);

	public Protocol getSendingProtocol();
	
	public void setSendingProtocol(Protocol protocol);
	
	public String getReceivingPort() ;
	
	public void setReceivingPort(String port);

	public Protocol getReceivingProtocol();
	
	public void setReceivingProtocol(Protocol protocol);
	
}
