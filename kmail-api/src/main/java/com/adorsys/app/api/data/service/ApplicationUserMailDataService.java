/**
 * 
 */
package com.adorsys.app.api.data.service;

import java.util.List;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;

/**
 * @author w2b
 *
 */
public interface ApplicationUserMailDataService {
	public void save(ApplicationUserMailModelRepresentation  appUserMailModel);
	public List<ApplicationUserMailModelRepresentation> findAll();
	public ApplicationUserMailModelRepresentation findOne(Long id);
	public void delete(Long id);
	public ApplicationUserMailModelRepresentation findByMail(MailModelRepresentation mailModel);
}
