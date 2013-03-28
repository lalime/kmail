/**
 * 
 */
package com.adorsys.app.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.MailServerModelRepresentation;
import com.adorsys.app.api.data.ServerType;

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

	private String protocol;
	
	@Column(unique=true)
	private String hostName;
	
	private String port ;

	private ServerType serverType;
	
	
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
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
	public ServerType getServerType() {
		return this.serverType;
	}

	@Override
	public void setServerType(ServerType serverType) {
		this.serverType = serverType;
	}

	@Override
	public String toString() {
		return "MailServer [protocol=" + protocol + ", hostName=" + hostName
				+ ", port=" + port + ", serverType=" + serverType + "]";
	}
	
	
}
