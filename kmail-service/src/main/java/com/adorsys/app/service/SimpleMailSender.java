/**
 * 
 */
package com.adorsys.app.service;

import java.util.List;

import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.service.MailSender;

/**
 * @author w2b
 *
 */
public class SimpleMailSender implements MailSender {

	@Override
	public void sendMails(List<MailModelRepresentation> mails) {
		if(mails == null || mails.isEmpty())
			return ;
		for (MailModelRepresentation mailModelRepresentation : mails) {
			sendMail(mailModelRepresentation);
		}
	}
	
	private void sendMail(MailModelRepresentation mail){
	}

}
