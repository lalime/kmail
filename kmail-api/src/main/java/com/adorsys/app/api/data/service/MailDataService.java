/**
 * 
 */
package com.adorsys.app.api.data.service;

import java.util.List;

import com.adorsys.app.api.data.MailModelRepresentation;

/**
 * @author w2b
 *
 */
public interface MailDataService {
	public void save(MailModelRepresentation mailModelRepresentation);
	public MailModelRepresentation findOne(Long id);
	public List<MailModelRepresentation> findAll();
	public void delete(Long id);
	public void delete(MailModelRepresentation mailModelRepresentation);
}
