/**
 * 
 */
package com.adorsys.app.desktop;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.adorsys.app.api.data.ApplicationUserModelRepresentation;
import com.adorsys.app.api.data.service.ApplicationUserDataService;
import com.adorsys.app.api.data.service.ApplicationUserMailAccountDataService;
import com.adorsys.app.api.data.service.ApplicationUserMailDataService;
import com.adorsys.app.api.data.service.MailAccountDataService;
import com.adorsys.app.api.data.service.MailDataService;
import com.adorsys.app.api.data.service.MailServerDataService;

/**
 * @author w2b
 * I use this class, to statically have access to the ApplicationContext, and by the way
 * make sure, every component I need to correctly Initialized.
 */
public class KmailApplicationContextUtils {
	
	private static GenericApplicationContext applicationContext;
	
	private static ApplicationUserDataService applicationUserDataService ;
	
	private static ApplicationUserMailAccountDataService appUserMailAccountDataService;
	
	private static ApplicationUserMailDataService appUserMailDataService;
	
	private static MailAccountDataService mailAccountDataService;
	
	private static MailDataService mailDataService;
	
	private static MailServerDataService mailServerDataService;
	
	private static boolean kmailApplicatioinContexUtilsInited  = false;
	
	private static ApplicationUserModelRepresentation applicationUser;
	
	private KmailApplicationContextUtils(){
		
	}
	public static void initApplicationContext(){
		if(kmailApplicatioinContexUtilsInited == true) {
			return ;
		}else {
			try {
				applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
				applicationContext.start();
				
				applicationUserDataService = applicationContext.getBean(ApplicationUserDataService.class);
				appUserMailAccountDataService = applicationContext.getBean(ApplicationUserMailAccountDataService.class);
				appUserMailDataService =  applicationContext.getBean(ApplicationUserMailDataService.class);
				mailAccountDataService = applicationContext.getBean(MailAccountDataService.class);
				mailDataService = applicationContext.getBean(MailDataService.class);
				mailServerDataService = applicationContext.getBean(MailServerDataService.class);
				kmailApplicatioinContexUtilsInited = true ;
				
			} catch (BeansException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private static void checkAndInitKmailApplicationContext(){
		if(kmailApplicatioinContexUtilsInited == false){
			throw new IllegalStateException("The Application Context  Is not yet inited ! Please Make sure you have called : " +
					"KmailApplicationContextUtils.initApplicationContext(); on in MainApp.java");
		}
	}
	public static ApplicationUserDataService getApplicationUserDataService(){
		checkAndInitKmailApplicationContext();
		return applicationUserDataService;
	}
	
	public static ApplicationUserMailAccountDataService getAppUserMailAccountDataService() {
		checkAndInitKmailApplicationContext();
		return appUserMailAccountDataService;
	}
	public static ApplicationUserMailDataService getAppUserMailDataService() {
		checkAndInitKmailApplicationContext();
		return appUserMailDataService;
	}
	public static MailAccountDataService getMailAccountDataService() {
		checkAndInitKmailApplicationContext();
		return mailAccountDataService;
	}
	public static MailDataService getMailDataService() {
		checkAndInitKmailApplicationContext();
		return mailDataService;
	}
	public static ApplicationUserModelRepresentation getApplicationUser() {
		return applicationUser;
	}
	public static void setApplicationUser(ApplicationUserModelRepresentation applicationUser) {
		KmailApplicationContextUtils.applicationUser = applicationUser;
	}
	public static MailServerDataService getMailServerDataService() {
		return mailServerDataService;
	}
	
}
