/**
 * 
 */
package com.adorsys.app.service.test;

import java.util.List;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.service.SimpleGmailPOP3WithSSLMailsReader;

/**
 * @author w2b
 *
 */
public class SimpleEmailReadTest {
	
	@Test
	public void testSimpleMailReader(){

        try {
            
            SimpleGmailPOP3WithSSLMailsReader mailReader  = new SimpleGmailPOP3WithSSLMailsReader("dev.kmail@gmail.com", "kmail.dev");
            List<MailModelRepresentation> mails = mailReader.readMails();
            System.out.println(mails);
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
	}
	
	public void testSend(){
		Email simpleEmail = new SimpleEmail();
	}
}
