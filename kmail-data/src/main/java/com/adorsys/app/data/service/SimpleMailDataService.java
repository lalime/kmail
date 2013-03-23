/**
 * 
 */
package com.adorsys.app.data.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.data.service.MailDataService;
import com.adorsys.app.data.domain.Mail;
import com.adorsys.app.data.repository.MailRepository;

/**
 * @author w2b
 *
 */
@Service
public class SimpleMailDataService implements MailDataService {
	@Autowired
	private MailRepository mailDataService;

	@Override
	public void save(MailModelRepresentation mailModelRepresentation) {
		mailDataService.save((Mail)mailModelRepresentation);
	}

	@Override
	public MailModelRepresentation findOne(Long id) {
		return mailDataService.findOne(id);
	}

	@Override
	public List<MailModelRepresentation> findAll() {
		Iterator<Mail> allFoundMails = mailDataService.findAll().iterator();
		List<MailModelRepresentation> results = new ArrayList<MailModelRepresentation>();
		while (allFoundMails.hasNext()) {
			Mail mail = (Mail) allFoundMails.next();
			results.add(mail);
		}
		return results;
	}

	@Override
	public void delete(Long id) {
		mailDataService.delete(id);
	}

	@Override
	public void delete(MailModelRepresentation mailModelRepresentation) {
		if(mailModelRepresentation == null) return ;
		Mail mail = (Mail)mailModelRepresentation;
		if(mail.getId() == null){
			return ;
		}
		mailDataService.delete(mail);
	}
	
}
