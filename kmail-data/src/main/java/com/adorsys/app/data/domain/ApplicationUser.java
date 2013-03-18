/**
 * 
 */
package com.adorsys.app.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.ApplicationUserModelRepresentation;

/**
 * @author w2b
 *
 */
@Entity
public class ApplicationUser extends AbstractPersistable<Long> implements ApplicationUserModelRepresentation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -403139252351306057L;
	
	@Column(unique=true)
	private String userName ;
	
	private String password ;
	
	private boolean defaultUser ;

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

	public boolean isDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(boolean defaultUser) {
		this.defaultUser = defaultUser;
	}

	@Override
	public String toString() {
		return "ApplicationUser [userName=" + userName + ", password="
				+ password + ", defaultUser=" + defaultUser + ", Id="
				+ getId() + ", isNew=" + isNew() + "]";
	}
	
}
