/**
 * 
 */
package com.adorsys.app.api.data;


/**
 * @author w2b
 *
 */
public interface ApplicationUserModelRepresentation {
	
	public String getUserName();
	
	public void setUserName(String userName);
	
	public String getPassword();
	
	public void setPassword(String passsword);
	
	public boolean isDefaultUser();
	
	public void setDefaultUser(boolean defaultUser);
	
}
