/**
 * 
 */
package com.adorsys.app.api.data;


/**
 * @author w2b
 * Abstraction of the user model. <br />
 * 
 * Example Of Representation
 * 
 * |userName    |password     |isDefaultUser   |
 * ---------------------------------------------
 * |b.TheMaster |retsaMehT.b  |true			   |
 * ---------------------------------------------
 */
public interface ApplicationUserModelRepresentation {
	
	public String getUserName();
	
	public void setUserName(String userName);
	
	public String getPassword();
	
	public void setPassword(String passsword);
	
	public boolean isDefaultUser();
	
	public void setDefaultUser(boolean defaultUser);
	
}
