/**
 * 
 */
package com.adorsys.app.data.domain;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.ApplicationUserModelRepresentation;
import com.adorsys.app.api.data.EditionState;
import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.data.ViewState;

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
	
	private Date storingDate;
	
	private long storingTime ;
	
	private ViewState viewState ;
	
	private EditionState editionState;
	
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

	public Date getStoringDate() {
		return storingDate;
	}

	public void setStoringDate(Date storingDate) {
		this.storingDate = storingDate;
	}

	public long getStoringTime() {
		return storingTime;
	}

	public void setStoringTime(long storingTime) {
		this.storingTime = storingTime;
	}

	public ViewState getViewState() {
		return viewState;
	}

	public void setViewState(ViewState viewState) {
		this.viewState = viewState;
	}

	public EditionState getEditionState() {
		return editionState;
	}

	public void setEditionState(EditionState editionState) {
		this.editionState = editionState;
	}

	
}
