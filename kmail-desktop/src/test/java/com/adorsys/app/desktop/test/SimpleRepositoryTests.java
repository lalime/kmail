/**
 * 
 */
package com.adorsys.app.desktop.test ;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.adorsys.app.api.data.service.ApplicationUserDataService;
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
	@Autowired
	ApplicationUserDataService applicationUserDataService;
	@Test
	public void testSaveApplicationUser(){
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setDefaultUser(true);
		applicationUser.setPassword("test123");
		applicationUser.setUserName("user0001");
		applicationUserDataService.save(applicationUser);
		ApplicationUser applicationUserTwo = new ApplicationUser();
		applicationUserTwo.setDefaultUser(true);
		applicationUserTwo.setPassword("test1234");
		applicationUserTwo.setUserName("user0002");
		applicationUserDataService.save(applicationUserTwo);
		Assert.assertEquals(applicationUser, applicationUserDataService.findOne(applicationUser.getId()));
		Assert.assertEquals(applicationUser, applicationUserDataService.findByUserName("user0001"));
	}
}
