/**
 * 
 */
package com.adorsys.app.data.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.adorsys.app.data.domain.ApplicationUser;
import com.adorsys.app.data.repository.ApplicationUserRepository;

/**
 * @author w2b
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:repository-context.xml")
@Transactional
public class SimpleRepositoryTests {
	private static Logger LOG = LoggerFactory.getLogger(SimpleRepositoryTests.class) ;
	
	@Autowired
	ApplicationUserRepository userRepository ;
	
	@Test
	public void testSaveApplicationUser(){
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setDefaultUser(true);
		applicationUser.setPassword("test123");
		applicationUser.setUserName("user0001");
		applicationUser = userRepository.save(applicationUser);
		Assert.assertEquals(applicationUser, userRepository.findOne(applicationUser.getId()));
		Assert.assertEquals(applicationUser, userRepository.findByPassword("test123"));
	}
}
