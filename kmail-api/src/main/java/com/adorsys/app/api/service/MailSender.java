/**
 * 
 */
package com.adorsys.app.api.service;

import java.util.List;

import com.adorsys.app.api.data.MailModelRepresentation;

/**
 * @author w2b
 *
 */
public interface MailSender {
	public void sendMails(List<MailModelRepresentation> mails);
	
	public void sendMail(MailModelRepresentation mail);
}
