/**
 * 
 */
package com.adorsys.app.data.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.EditionState;
import com.adorsys.app.api.data.ViewState;
import com.adorsys.app.api.data.service.ApplicationUserDataService;
import com.adorsys.app.api.data.service.ApplicationUserMailDataService;
import com.adorsys.app.data.domain.AppUserMail;
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
	
	@Autowired
	ApplicationUserMailDataService appUserMailDataService;
	@Test
	public void testSaveApplicationUser(){
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setDefaultUser(true);
		applicationUser.setPassword("test123");
		applicationUser.setUserName("user0001");
		applicationUserDataService.save(applicationUser);
		Assert.assertEquals(applicationUser, applicationUserDataService.findOne(applicationUser.getId()));
		Assert.assertEquals(applicationUser, applicationUserDataService.findByUserName("user0001"));
	}
	@Test
	public void testAppUserMails(){
		AppUserMail appUserMail = new AppUserMail();
		appUserMail.setEditionState(EditionState.SENDED);
		appUserMail.setViewState(ViewState.READED);
		
		AppUserMail appUserMail2 = new AppUserMail();
		appUserMail2.setEditionState(EditionState.RECEIVED);
		appUserMail2.setViewState(ViewState.UN_READED);
		
		appUserMailDataService.save(appUserMail);
		appUserMailDataService.save(appUserMail2);
		
		List<ApplicationUserMailModelRepresentation> sendedMails = appUserMailDataService.findSendedMails();
		Assert.assertEquals(1, sendedMails.size());
		
		List<ApplicationUserMailModelRepresentation> unreadedReceivedMails = appUserMailDataService.findUnreadedReceivedMails();
		Assert.assertEquals(1, unreadedReceivedMails.size());
	}
}
