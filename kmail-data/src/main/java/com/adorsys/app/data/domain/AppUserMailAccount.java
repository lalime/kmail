/**
 * 
 */
package com.adorsys.app.data.domain;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.AppUserMailAccountRepresentation;
import com.adorsys.app.api.data.ApplicationUserModelRepresentation;
import com.adorsys.app.api.data.MailAccountModelRepresentation;

/**
 * @author w2b
 *
 */
@Entity
public class AppUserMailAccount extends AbstractPersistable<Long> implements AppUserMailAccountRepresentation{
	
	private static final long serialVersionUID = 7517136670448466409L;

	private ApplicationUser applicationUser ;
	
	private MailAccount mailAccount;
	
	private boolean active ;
	
	private Date dateOfCreation ;

	public ApplicationUserModelRepresentation getApplicationUser() {
		return applicationUser;
	}

	public void setApplicationUser(
			ApplicationUserModelRepresentation applicationUser) {
		this.applicationUser = (ApplicationUser) applicationUser;
	}

	public MailAccountModelRepresentation getMailAccount() {
		return mailAccount;
	}

	public void setMailAccount(MailAccountModelRepresentation mailAccount) {
		this.mailAccount = (MailAccount) mailAccount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public String toString() {
		return "AppUserMailAccount [applicationUser=" + applicationUser
				+ ", mailAccount=" + mailAccount + ", active=" + active
				+ ", dateOfCreation=" + dateOfCreation + ", Id=" + getId()
				+ ", isNew=" + isNew() + "]";
	}
	
	
}
