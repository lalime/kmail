/**
 * 
 */
package com.adorsys.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.service.ApplicationUserMailDataService;
import com.adorsys.app.data.repository.AppUserMailRepository;

/**
 * @author w2b
 *
 */
@Service
public class SimpleApplicationUserMailDataService implements
		ApplicationUserMailDataService {
	
	@Autowired
	private AppUserMailRepository appUserMailRepository;
	
}
