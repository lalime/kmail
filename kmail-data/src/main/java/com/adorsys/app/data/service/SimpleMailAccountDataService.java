package com.adorsys.app.data.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.service.MailAccountDataService;
import com.adorsys.app.data.domain.MailAccount;
import com.adorsys.app.data.repository.MailAccountRepository;
/**
 * 
 * @author w2b
 *
 */
@Service
public class SimpleMailAccountDataService implements MailAccountDataService {
	
	@Autowired
	private MailAccountRepository mailAccountRepository;

	@Override
	public void save(MailAccountModelRepresentation accountModelRepresentation) {
		mailAccountRepository.save((MailAccount)accountModelRepresentation);
	}

	@Override
	public MailAccountModelRepresentation findOne(Long id) {
		return mailAccountRepository.findOne(id);
	}

	@Override
	public List<MailAccountModelRepresentation> findAll() {
		Iterator<MailAccount> mailAccounts = mailAccountRepository.findAll().iterator();
		List<MailAccountModelRepresentation> results = new ArrayList<MailAccountModelRepresentation>();
		while (mailAccounts.hasNext()) {
			MailAccount mailAccount = (MailAccount) mailAccounts.next();
			results.add(mailAccount);
		}
		return results;
	}

	@Override
	public MailAccountModelRepresentation findByUserName(String userName) {
		return mailAccountRepository.findByUserName(userName);
	}
	
}
