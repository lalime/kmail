/**
 * 
 */
package com.adorsys.app.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.adorsys.app.data.domain.AppUserMailAccount;

/**
 * @author w2b
 *
 */
public interface AppUserMailAccountRepository extends CrudRepository<AppUserMailAccount	, Long> {

}
