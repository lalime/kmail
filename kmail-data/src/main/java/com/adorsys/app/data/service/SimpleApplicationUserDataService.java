/**
 * 
 */
package com.adorsys.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.ApplicationUserModelRepresentation;
import com.adorsys.app.api.data.service.ApplicationUserDataService;
import com.adorsys.app.data.domain.ApplicationUser;
import com.adorsys.app.data.repository.ApplicationUserRepository;

/**
 * @author w2b
 *
 */
@Service
public class SimpleApplicationUserDataService implements
		ApplicationUserDataService {
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;

	@Override
	public void save(ApplicationUserModelRepresentation userModelRepresentation) {
		applicationUserRepository.save((ApplicationUser)userModelRepresentation);
	}

	@Override
	public ApplicationUserModelRepresentation findOne(Long id) {
		return applicationUserRepository.findOne(id);
	}

	@Override
	public ApplicationUserModelRepresentation findByUserName(String userName) {
		return applicationUserRepository.findByUserName(userName);
	}
	
}
