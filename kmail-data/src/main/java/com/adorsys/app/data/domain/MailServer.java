/**
 * 
 */
package com.adorsys.app.data.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.adorsys.app.api.data.MailServerModelRepresentation;

/**
 * @author w2b
 *
 */
public class MailServer extends AbstractPersistable<Long> implements MailServerModelRepresentation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5106523413753201651L;

	private String protocol;
	
	private String hostName;
	
	private String port ;

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
	
}
