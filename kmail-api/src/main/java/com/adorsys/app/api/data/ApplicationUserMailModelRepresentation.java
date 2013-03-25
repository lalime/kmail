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
 * |mailAccount   |applicationUser   |mail        |receptionDate   |receptionTime    |readed    |inTrash|inDraft|
 * --------------------------------------------------------------------------------------------------------------
 * |mailAccountId |applicationUserId |mailId      |22-03-2010      |15:15:30         |false     |false  |false  |
 * ------------------------------------------------------------------------------------------------------
 */
public interface ApplicationUserMailModelRepresentation {
	public MailAccountModelRepresentation getMailAccount();
	
	public void setMailAccount(MailAccountModelRepresentation mailAccount);
	
	public ApplicationUserModelRepresentation getApplicationUser();
	
	public void setApplicationUser(ApplicationUserModelRepresentation applicationUser);
	
	public MailModelRepresentation getMail();
	
	public void setMail(MailModelRepresentation mailModel);
	
	public Date getStoringDate();
	
	public void setStoringDate(Date storingDate);
	
	public long getStoringTime();
	
	public void setStoringTime(long storingTime);
	
	public ViewState getViewState();
	
	public void setViewState(ViewState viewState);
	
	public EditionState getEditionState();
	
	public void setEditionState(EditionState editionState);
}
