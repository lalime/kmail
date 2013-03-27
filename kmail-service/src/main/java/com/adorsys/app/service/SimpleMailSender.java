/**
 * 
 */
package com.adorsys.app.service;

import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.mail.service.MailSender;

/**
 * @author w2b
 *
 */
public class SimpleMailSender implements MailSender {
	
	private MailAccountModelRepresentation mailAccount ;
	
	public SimpleMailSender(MailAccountModelRepresentation mailAccount) {
		super();
		this.mailAccount = mailAccount;
	}
	
	@Override
	public void sendMails(List<MailModelRepresentation> mails) {
		if(mails == null || mails.isEmpty())
			return ;
		for (MailModelRepresentation mailModelRepresentation : mails) {
			sendMail(mailModelRepresentation);
		}
	}
	@Override
	public void sendMail(MailModelRepresentation mail){
		SimpleEmail simpleEmail = new SimpleEmail();
		try {
			simpleEmail.setHostName(this.mailAccount.getMailServer().getHostName());
			simpleEmail.setSmtpPort(new Integer(this.mailAccount.getMailServer().getPort()));
			simpleEmail.setAuthenticator(new DefaultAuthenticator(this.mailAccount.getUserName(), this.mailAccount.getPassword()));
			simpleEmail.setFrom(mail.getAddressFrom());
			simpleEmail.setTo(mail.getAddressTo());
			simpleEmail.setSubject(mail.getSubject());
			simpleEmail.setMsg(mail.getBody());
			simpleEmail.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
