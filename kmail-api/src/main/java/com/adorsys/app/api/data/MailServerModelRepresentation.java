/**
 * 
 */
package com.adorsys.app.api.data;

/**
 * @author w2b
 *
 */
public interface MailServerModelRepresentation {

	public String getSendingHostName();
	
	public void setSendingHostName(String hostName);
	
	public String getSendingPort() ;
	
	public void setSendingPort(String port);

	public String getReceivingHostName();
	
	public void setReceivingHostName(String hostName);
	
	public Protocol getSendingProtocol();
	
	public void setSendingProtocol(Protocol protocol);
	
	public String getReceivingPort() ;
	
	public void setReceivingPort(String port);

	public Protocol getReceivingProtocol();
	
	public void setReceivingProtocol(Protocol protocol);
	
}
