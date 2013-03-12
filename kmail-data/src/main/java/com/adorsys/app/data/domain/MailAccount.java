/**
 * 
 */
package com.adorsys.app.data.domain;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.MailAccountModelRepresentation;

/**
 * @author w2b
 *
 */
@Entity
public class MailAccount extends AbstractPersistable<Long> implements MailAccountModelRepresentation{

	private static final long serialVersionUID = 4584235331103333321L;

	private String protocol;
	
	private String url;
	
	private String port ;
	
	private String userName ;
	
	private String password;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

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
	
}
