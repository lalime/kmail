/**
 * 
 */
package com.adorsys.app.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.MailServerModelRepresentation;
import com.adorsys.app.api.data.Protocol;

/**
 * @author w2b
 *
 */
@Entity
public class MailServer extends AbstractPersistable<Long> implements MailServerModelRepresentation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5106523413753201651L;


	private String port ;
	
	@Column(unique=true)
	private String hostName;

	private Protocol protocol;

	
	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "MailServer [protocol=" + protocol + ", hostName=" + hostName
				+ ", port=" + port + "]";
	}
	
	
}
