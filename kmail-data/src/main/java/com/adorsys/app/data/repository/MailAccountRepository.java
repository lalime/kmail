/**
 * 
 */
package com.adorsys.app.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.data.domain.MailAccount;

/**
 * @author w2b
 *
 */
public interface MailAccountRepository extends CrudRepository<MailAccount, Long>{
	public MailAccountModelRepresentation findByHostName(String hostName);
}
