/**
 * 
 */
package com.adorsys.app.api.data;

/**
 * @author w2b
 *
 */
public interface MailServerModelRepresentation {
	
	public String getProtocol();
	
	public void setProtocol(String protocol);
	
	public String getHostName();
	
	public void setHostName(String hostName);

	public String getPort() ;
	
	public void setPort(String port);
}
