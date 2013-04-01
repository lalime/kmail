/**
 * 
 */
package com.adorsys.app.service;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.mail.service.MailSender;

/**
 * @author w2b
 * 
 */
public class HtmlMailSender implements MailSender {
	private MailAccountModelRepresentation mailAccount;
	
	public HtmlMailSender(MailAccountModelRepresentation mailAccount) {
		this.mailAccount = mailAccount;
	}
	@Override
	public void sendMails(List<MailModelRepresentation> mails) {
		if (mails == null || mails.isEmpty())
			return;
		for (MailModelRepresentation mailModelRepresentation : mails) {
			sendMail(mailModelRepresentation);
		}
	}

	@Override
	public void sendMail(MailModelRepresentation mail) {
		// Create the email message
		HtmlEmail email = new HtmlEmail();
		try {
			email.setHostName(mailAccount.getMailServer().getHostName());
			for (String destinator : mail.getAddressTo()) {
				email.addTo(destinator);
			}
			email.setFrom(mail.getAddressFrom(), null);
			email.setSubject(mail.getSubject());
			email.setMsg(mail.getSubject());
			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
