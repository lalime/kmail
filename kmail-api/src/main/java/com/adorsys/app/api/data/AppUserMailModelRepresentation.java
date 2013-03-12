/**
 * 
 */
package com.adorsys.app.api.data;

import java.util.Date;

/**
 * @author w2b
 * 
 * List of user's mails associated to his account.
 */
public interface AppUserMailModelRepresentation {
	public MailAccountModelRepresentation getMailAccount();
	
	public void setMailAccount(MailAccountModelRepresentation mailAccount);
	
	public ApplicationUserModelRepresentation getApplicationUser();
	
	public void setApplicationUser(ApplicationUserModelRepresentation applicationUser);
	
	public MailModelRepresentation getMail();
	
	public void setMail(MailModelRepresentation mailModel);
	
	public Date getReceptionDate();
	
	public void setReceptionDate(Date receptionDate);
	
	public long getReceptionTime();
	
	public void setReceptionTime(long receptionTime);
	
	public boolean isReaded();
	
	public void setReaded(boolean isReaded);
	
	public boolean isInTrash();
	
	public void setInTrash(boolean inTrash);
}
