/**
 * 
 */
package com.adorsys.app.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.data.domain.Mail;

/**
 * @author w2b
 *
 */
public interface MailRepository extends PagingAndSortingRepository<Mail, Long>{
	public List<MailModelRepresentation> findByAddressFromAndReceivedDate(String addressFrom,Date receivedDate);
}
