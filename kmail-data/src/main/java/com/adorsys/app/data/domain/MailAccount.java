/**
 * 
 */
package com.adorsys.app.data.domain;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailServerModelRepresentation;

/**
 * @author w2b
 *
 */
@Entity
public class MailAccount extends AbstractPersistable<Long> implements MailAccountModelRepresentation{

	private static final long serialVersionUID = 4584235331103333321L;

	private String userName ;
	
	private String password;

	private MailServer mailServer;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MailServer getMailServer() {
		return mailServer;
	}

	@Override
	public void setMailServer(MailServerModelRepresentation mailServer) {
		this.mailServer = (MailServer) mailServer;
	}
	
	
}
