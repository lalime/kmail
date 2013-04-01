/**
 * 
 */
package com.adorsys.app.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.adorsys.app.data.domain.MailServer;

/**
 * @author w2b
 *
 */
public interface MailServerRepository extends CrudRepository<MailServer, Long>{
	public MailServer findBySendingHostName(String hostName);
	public MailServer findByReceivingHostName(String hostName);
}
