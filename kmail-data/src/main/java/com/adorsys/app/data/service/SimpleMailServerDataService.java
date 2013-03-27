/**
 * 
 */
package com.adorsys.app.data.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorsys.app.api.data.MailServerModelRepresentation;
import com.adorsys.app.api.data.service.MailServerDataService;
import com.adorsys.app.data.domain.MailServer;
import com.adorsys.app.data.repository.MailServerRepository;

/**
 * @author w2b
 *
 */
@Service
public class SimpleMailServerDataService implements MailServerDataService{
	@Autowired  MailServerRepository mailServerRepository;
	
	@Override
	public MailServerModelRepresentation save(
			MailServerModelRepresentation mailServerModel) {
		return mailServerRepository.save((MailServer)mailServerModel);
	}

	@Override
	public List<MailServerModelRepresentation> findAll() {
		List<MailServerModelRepresentation> results = new ArrayList<MailServerModelRepresentation>();
		Iterator<MailServer> foundMailServers = mailServerRepository.findAll().iterator();
		while (foundMailServers.hasNext()) {
			MailServer mailServer = (MailServer) foundMailServers.next();
			results.add(mailServer);
		}
		return results;
	}

	@Override
	public void delete(Long id) {
		mailServerRepository.delete(id);
	}

}
