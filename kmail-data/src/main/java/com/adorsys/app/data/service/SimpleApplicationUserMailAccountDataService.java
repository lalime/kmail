/**
 * 
 */
package com.adorsys.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.service.ApplicationUserMailAccountDataService;
import com.adorsys.app.data.repository.AppUserMailAccountRepository;

/**
 * @author w2b
 *
 */
@Service
public class SimpleApplicationUserMailAccountDataService implements
		ApplicationUserMailAccountDataService {
	
	@Autowired
	private AppUserMailAccountRepository appUserMailAccountRepository;
	
}
