/**
 * 
 */
package com.adorsys.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.service.MailDataService;
import com.adorsys.app.data.repository.MailRepository;

/**
 * @author w2b
 *
 */
@Service
public class SimpleMailDataService implements MailDataService {
	@Autowired
	private MailRepository mailDataService;
	
}
