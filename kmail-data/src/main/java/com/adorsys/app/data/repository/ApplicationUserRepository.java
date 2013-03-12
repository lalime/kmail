/**
 * 
 */
package com.adorsys.app.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.adorsys.app.data.domain.ApplicationUser;

/**
 * @author w2b
 *
 */
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long>{
	
	public ApplicationUser findByPassword(String password);
}
