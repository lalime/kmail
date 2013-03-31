/**
 * 
 */
package com.adorsys.app.api.data;

/**
 * @author w2b
 *
 */
public interface MailServerModelRepresentation {

	public String getPort() ;
	
	public void setPort(String port);
	
	public String getHostName();
	
	public void setHostName(String hostName);

	public Protocol getProtocol();
	
	public void setProtocol(Protocol protocol);
	
}
