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

	@Column(unique=true)
	private String sendingHostName;

	@Column(unique=true)
	private String receivingHostName;

	private String sendingPort;
	

	private Protocol sendingProtocol;
	
	private String receivingPort ;
	
	private Protocol receivingProtocol ;
	
	public String getSendingHostName() {
		return sendingHostName;
	}

	public void setSendingHostName(String sendingHostName) {
		this.sendingHostName = sendingHostName;
	}

	public String getReceivingHostName() {
		return receivingHostName;
	}

	public void setReceivingHostName(String receivingHostName) {
		this.receivingHostName = receivingHostName;
	}

	public String getSendingPort() {
		return sendingPort;
	}

	public void setSendingPort(String sendingPort) {
		this.sendingPort = sendingPort;
	}

	public Protocol getSendingProtocol() {
		return sendingProtocol;
	}

	public void setSendingProtocol(Protocol sendingProtocol) {
		this.sendingProtocol = sendingProtocol;
	}

	public String getReceivingPort() {
		return receivingPort;
	}

	public void setReceivingPort(String receivingPort) {
		this.receivingPort = receivingPort;
	}

	public Protocol getReceivingProtocol() {
		return receivingProtocol;
	}

	public void setReceivingProtocol(Protocol receivingProtocol) {
		this.receivingProtocol = receivingProtocol;
	}

	@Override
	public String toString() {
		return "MailServer [sendingHostName=" + sendingHostName
				+ ", receivingHostName=" + receivingHostName + ", sendingPort="
				+ sendingPort + ", sendingProtocol=" + sendingProtocol
				+ ", receivingPort=" + receivingPort + ", receivingProtocol="
				+ receivingProtocol + "]";
	}
	
	
}
