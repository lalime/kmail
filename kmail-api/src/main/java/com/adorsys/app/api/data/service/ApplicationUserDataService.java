/**
 * 
 */
package com.adorsys.app.api.data.service;

import com.adorsys.app.api.data.ApplicationUserModelRepresentation;

/**
 * @author w2b
 *
 */
public interface ApplicationUserDataService {
	public void save(ApplicationUserModelRepresentation userModelRepresentation);
	public ApplicationUserModelRepresentation findOne(Long id);
	public ApplicationUserModelRepresentation findByUserName(String userName);
}
