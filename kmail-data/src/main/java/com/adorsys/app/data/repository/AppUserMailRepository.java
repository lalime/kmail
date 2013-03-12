/**
 * 
 */
package com.adorsys.app.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adorsys.app.data.domain.AppUserMail;

/**
 * @author w2b
 *
 */
public interface AppUserMailRepository extends PagingAndSortingRepository<AppUserMail, Long> {

}
