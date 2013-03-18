/**
 * 
 */
package com.adorsys.app.api.data;

import java.util.Date;

/**
 * @author w2b
 * 
 * Table of users with theirs mails and theirs associated mail account to this mail.
 * 
 * |mailAccount   |applicationUser   |mail        |receptionDate   |receptionTime    |readed    |inTrash|
 * ------------------------------------------------------------------------------------------------------
 * |mailAccountId |applicationUserId |mailId      |22-03-2010      |15:15:30         |false     |false  |
 * ------------------------------------------------------------------------------------------------------
 */
public interface ApplicationUserMailModelRepresentation {
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
