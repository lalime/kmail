package com.adorsys.app.desktop;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.api.data.EditionState;
import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.data.ViewState;
import com.adorsys.app.data.domain.AppUserMail;
import com.adorsys.app.data.domain.Mail;
import com.adorsys.app.service.SimplePOP3WithSSLMailReader;

public class MainApp extends Application {
	private static Logger LOG = LoggerFactory.getLogger(MainApp.class) ;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

	public void start(Stage stage) throws Exception {
		LOG.info("Starting Hello JavaFX and Maven demonstration application");
        KmailApplicationContextUtils.initApplicationContext();
        ViewManager.initViewManager(stage);
        ViewManager.getViewManager().showLoginScreen();
        
        Timer timer = new Timer(false);
        timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				try {
					MainApp.readAndSaveMails();					
				} catch (Exception e) {
					LOG.error("An Error Occured : "+e.getMessage(),e);
				}
			}
		}, 5000,5000);
    }
	public static void readAndSaveMails(){
		LOG.debug("quering mails ...");
		List<MailAccountModelRepresentation> mailAccounts = KmailApplicationContextUtils.getMailAccountDataService().findAll();
		int numberOfReceivedMails = 0;
		for (MailAccountModelRepresentation mailAccountModelRepresentation : mailAccounts) {
			SimplePOP3WithSSLMailReader simplePOP3WithSSLMailReader = new SimplePOP3WithSSLMailReader(mailAccountModelRepresentation);
			List<MailModelRepresentation> receivedMails = simplePOP3WithSSLMailReader.readMails();
			for (MailModelRepresentation mailModelRepresentation : receivedMails) {
				LOG.info("Received Mails :  "+mailModelRepresentation);
				MailModelRepresentation cloneMail = cloneMail(mailModelRepresentation);
				if(!KmailApplicationContextUtils.getMailDataService().isNewReceivedMail(mailModelRepresentation)){
					continue;
				}
				
				KmailApplicationContextUtils.getMailDataService().save(cloneMail);
				AppUserMail appUserMail = new AppUserMail();
				appUserMail.setApplicationUser(KmailApplicationContextUtils.getApplicationUser());
				appUserMail.setEditionState(EditionState.RECEIVED);
				appUserMail.setMail(cloneMail );
				appUserMail.setMailAccount(mailAccountModelRepresentation);
				appUserMail.setStoringDate(new Date());
				appUserMail.setStoringTime(new Date().getTime());
				appUserMail.setViewState(ViewState.UN_READED);
				KmailApplicationContextUtils.getAppUserMailDataService().save(appUserMail);
				numberOfReceivedMails ++;
			}
		}
		LOG.debug("... finished, "+numberOfReceivedMails+" received mails");
	}
	private static MailModelRepresentation cloneMail(MailModelRepresentation mailModel){
		Mail mail = new Mail();
		mail.setAddressFrom(mailModel.getAddressFrom());
		mail.setAddressTo(mailModel.getAddressTo());
		mail.setBody(mailModel.getBody());
		mail.setContentType(mailModel.getContentType());
		mail.setReceivedDate(mailModel.getReceivedDate());
		mail.setSendDate(mailModel.getSendDate());
		mail.setSubject(mail.getSubject());
		return mail ;
	}
}
