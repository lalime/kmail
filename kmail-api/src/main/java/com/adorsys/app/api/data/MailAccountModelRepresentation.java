/**
 * 
 */
package com.adorsys.app.api.data;

/**
 * @author w2b
 * 
 * A simple Abstraction of the mail.
 * 
 * |protocol  |hostName   |port		|userName   			|password  |
 * ---------------------------------------------------------------------
 * |		  |			  |			|abc.def@yourdomain.com	|******	   |
 * ---------------------------------------------------------------------
 */
public interface MailAccountModelRepresentation {
	
	public String getProtocol();
	
	public void setProtocol(String protocol);
	
	public String getHostName();
	
	public void setHostName(String hostName);

	public String getPort() ;
	
	public void setPort(String port);
	
	public String getUserName();
	
	public void setUserName(String userName);
	
	public String getPassword();
	
	public void setPassword(String password);
}
