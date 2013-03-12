/**
 * 
 */
package com.adorsys.app.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adorsys.app.data.domain.Mail;

/**
 * @author w2b
 *
 */
public interface MailRepository extends PagingAndSortingRepository<Mail, Long>{

}
