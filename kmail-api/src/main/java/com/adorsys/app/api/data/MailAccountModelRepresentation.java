/**
 * 
 */
package com.adorsys.app.api.data;

/**
 * @author w2b
 * 
 * A simple Abstraction of the mail.
 * 
 * |mailServerId|userName   			|password  |
 * -------------------------------------------------
 * |1			|abc.def@yourdomain.com	|******	   |
 * -------------------------------------------------
 */
public interface MailAccountModelRepresentation {
	
	public MailServerModelRepresentation getMailServer();
	
	public void setMailServer(MailServerModelRepresentation mailServer);
	
	public String getUserName();
	
	public void setUserName(String userName);
	
	public String getPassword();
	
	public void setPassword(String password);
}
