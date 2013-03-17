/**
 * 
 */
package com.adorsys.app.desktop;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.adorsys.app.data.repository.AppUserMailAccountRepository;
import com.adorsys.app.data.repository.AppUserMailRepository;
import com.adorsys.app.data.repository.ApplicationUserRepository;
import com.adorsys.app.data.repository.MailAccountRepository;
import com.adorsys.app.data.repository.MailRepository;

/**
 * @author w2b
 * I use this class, to statically have access to the ApplicationContext, and by the way
 * make sure, every component I need to correctly Initialized.
 */
public class KmailApplicationContextUtils {
	
	private static GenericApplicationContext applicationContext;
	
	private static ApplicationUserRepository applicationUserRepository ;
	
	private static AppUserMailAccountRepository appUserMailAccountRepository;
	
	private static AppUserMailRepository appUserMailRepository;
	
	private static MailAccountRepository mailAccountRepository;
	
	private static MailRepository mailRepository;
	
	private static boolean kmailApplicatioinContexUtilsInited  = false;
	
	private KmailApplicationContextUtils(){
		
	}
	public static void initApplicationContext(){
		if(kmailApplicatioinContexUtilsInited == true) {
			return ;
		}else {
			try {
				applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
				applicationContext.start();
				
				applicationUserRepository = applicationContext.getBean(ApplicationUserRepository.class);
				appUserMailAccountRepository = applicationContext.getBean(AppUserMailAccountRepository.class);
				appUserMailRepository =  applicationContext.getBean(AppUserMailRepository.class);
				mailAccountRepository = applicationContext.getBean(MailAccountRepository.class);
				mailRepository = applicationContext.getBean(MailRepository.class);
				
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
	public static ApplicationUserRepository getApplicationUserRepository(){
		checkAndInitKmailApplicationContext();
		return applicationUserRepository;
	}
	
	public static AppUserMailAccountRepository getAppUserMailAccountRepository() {
		checkAndInitKmailApplicationContext();
		return appUserMailAccountRepository;
	}
	public static AppUserMailRepository getAppUserMailRepository() {
		checkAndInitKmailApplicationContext();
		return appUserMailRepository;
	}
	public static MailAccountRepository getMailAccountRepository() {
		checkAndInitKmailApplicationContext();
		return mailAccountRepository;
	}
	public static MailRepository getMailRepository() {
		checkAndInitKmailApplicationContext();
		return mailRepository;
	}
	
}
