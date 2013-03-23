/**
 * 
 */
package com.adorsys.app.data.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.service.ApplicationUserMailDataService;
import com.adorsys.app.data.domain.AppUserMail;
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

	@Override
	public void save(ApplicationUserMailModelRepresentation appUserMailModel) {
		appUserMailRepository.save((AppUserMail)appUserMailModel);
	}

	@Override
	public List<ApplicationUserMailModelRepresentation> findAll() {
		Iterator<AppUserMail> appUserMailFound= appUserMailRepository.findAll().iterator();
		List<ApplicationUserMailModelRepresentation> foundAppUserMails = new ArrayList<ApplicationUserMailModelRepresentation>();
		while (appUserMailFound.hasNext()) {
			AppUserMail appUserMail = (AppUserMail) appUserMailFound.next();
			foundAppUserMails.add(appUserMail);
		}
		return foundAppUserMails;
	}

	@Override
	public ApplicationUserMailModelRepresentation findOne(Long id) {
		return appUserMailRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		appUserMailRepository.delete(id);
	}
	
}
