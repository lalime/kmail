/**
 * 
 */
package com.adorsys.app.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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

	@Column(unique = true)
	private String userName ;
	
	private String password;

	@ManyToOne
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
	
	public void setMailServer(MailServer mailServer) {
		this.mailServer = mailServer;
	}

	@Override
	public void setMailServer(MailServerModelRepresentation mailServer) {
		setMailServer((MailServer) mailServer);
	}

	@Override
	public String toString() {
		return "MailAccount [userName=" + userName + ", password=" + password
				+ ", mailServer=" + mailServer.getId() + "-"+mailServer.getHostName()+"]";
	}
	
}
