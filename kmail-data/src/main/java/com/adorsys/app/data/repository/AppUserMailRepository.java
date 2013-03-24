/**
 * 
 */
package com.adorsys.app.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.data.domain.AppUserMail;
import com.adorsys.app.data.domain.Mail;

/**
 * @author w2b
 *
 */
public interface AppUserMailRepository extends PagingAndSortingRepository<AppUserMail, Long> {
	public AppUserMail findByMail(Mail mail);
}
