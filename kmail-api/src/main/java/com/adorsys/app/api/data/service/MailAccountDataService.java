/**
 * 
 */
package com.adorsys.app.api.data.service;

import java.util.List;

import com.adorsys.app.api.data.MailAccountModelRepresentation;

/**
 * @author w2b
 *
 */
public interface MailAccountDataService {
	public void save(MailAccountModelRepresentation accountModelRepresentation);
	public MailAccountModelRepresentation findOne(Long id);
	public List<MailAccountModelRepresentation> findAll();
	public MailAccountModelRepresentation findByHostName(String hostName);
}
