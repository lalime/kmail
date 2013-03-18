package com.adorsys.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.service.MailAccountDataService;
import com.adorsys.app.data.repository.MailAccountRepository;
/**
 * 
 * @author w2b
 *
 */
@Service
public class SimpleMailAccountDataService implements MailAccountDataService {
	
	@Autowired
	private MailAccountRepository mailAccountDataService;
	
}
