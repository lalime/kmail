/**
 * 
 */
package com.adorsys.app.data.domain;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.ApplicationUserModelRepresentation;
import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;

/**
 * @author w2b
 *
 */
@Entity
public class AppUserMail extends AbstractPersistable<Long> implements ApplicationUserMailModelRepresentation{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2487525761297456275L;
	
	private MailAccount mailAccount ;
	
	private ApplicationUser applicationUser ;
	
	private Mail mail ;
	
	private Date receptionDate;
	
	private long receptionTime ;
	
	private boolean readed ;
	
	private boolean inTrash ;

	public MailAccountModelRepresentation getMailAccount() {
		return mailAccount;
	}

	public void setMailAccount(MailAccountModelRepresentation mailAccount) {
		this.mailAccount = (MailAccount) mailAccount;
	}

	public ApplicationUserModelRepresentation getApplicationUser() {
		return applicationUser;
	}

	public void setApplicationUser(
			ApplicationUserModelRepresentation applicationUser) {
		this.applicationUser = (ApplicationUser) applicationUser;
	}

	public MailModelRepresentation getMail() {
		return mail;
	}

	public void setMail(MailModelRepresentation mail) {
		this.mail = (Mail) mail;
	}

	public Date getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(Date receptionDate) {
		this.receptionDate = receptionDate;
	}

	public long getReceptionTime() {
		return receptionTime;
	}

	public void setReceptionTime(long receptionTime) {
		this.receptionTime = receptionTime;
	}
	
	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public boolean isInTrash() {
		return inTrash;
	}

	public void setInTrash(boolean inTrash) {
		this.inTrash = inTrash;
	}

	@Override
	public String toString() {
		return "AppUserMail [mailAccount=" + mailAccount + ", applicationUser="
				+ applicationUser + ", mail=" + mail + ", receptionDate="
				+ receptionDate + ", receptionTime=" + receptionTime
				+ ", readed=" + readed + ", inTrash=" + inTrash + ", Id="
				+ getId() + ", New=" + isNew() + "]";
	}
	
}
