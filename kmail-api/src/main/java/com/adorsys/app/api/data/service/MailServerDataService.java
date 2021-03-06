/**
 * 
 */
package com.adorsys.app.api.data.service;

import java.util.List;

import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.data.MailServerModelRepresentation;

/**
 * @author w2b
 *
 */
public interface MailServerDataService {
	public MailServerModelRepresentation save(MailServerModelRepresentation mailServerModel);
	public List<MailServerModelRepresentation> findAll();
	public void delete(Long id);
	public MailServerModelRepresentation findBySendingHostName(String hostName);
	public MailServerModelRepresentation findByReceivingHostName(String hostName);
}
