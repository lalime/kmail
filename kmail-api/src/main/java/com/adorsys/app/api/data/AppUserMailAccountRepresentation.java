/**
 * 
 */
package com.adorsys.app.api.data;

import java.util.Date;

/**
 * @author w2b
 * 
 * Use this class to lose coupling between application user and their mail accounts.
 */
public interface AppUserMailAccountRepresentation {
	
	public ApplicationUserModelRepresentation getApplicationUser();
	
	public void setApplicationUser(ApplicationUserModelRepresentation applicationUserModel);
	
	public MailAccountModelRepresentation getMailAccount();
	
	public void setMailAccount(MailAccountModelRepresentation mailAccount);
	
	public boolean isActive();
	
	public void setActive(boolean active);
	
	public Date getDateOfCreation();
	
	public void setDateOfCreation(Date  dateOfCreation);
}
