/**
 * 
 */
package com.adorsys.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.ContentType;
import javax.mail.internet.ParseException;

import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.mail.service.MailReader;
import com.adorsys.app.service.bean.SimpleMailBean;
import com.sun.mail.pop3.POP3SSLStore;

/**
 * @author w2b
 *
 */
public class SimplePOP3WithSSLMailReader implements MailReader{
	private MailAccountModelRepresentation mailAccount ;


	private Session session = null;
    private Store store = null;
    private Folder folder;
    
    
   	public SimplePOP3WithSSLMailReader(MailAccountModelRepresentation mailAccount) {
   		super();
   		this.mailAccount = mailAccount;
   	}
    
    private void connect() throws Exception {
        
        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        
        Properties pop3Props = new Properties();
        
        pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
        pop3Props.setProperty("mail.pop3.port",  this.mailAccount.getMailServer().getReceivingPort());
        pop3Props.setProperty("mail.pop3.socketFactory.port", this.mailAccount.getMailServer().getReceivingPort());
        
        URLName url = new URLName(this.mailAccount.getMailServer().getReceivingProtocol().toString(), this.mailAccount.getMailServer().getReceivingHostName(), new Integer(this.mailAccount.getMailServer().getReceivingPort()), "",
                this.mailAccount.getUserName(), this.mailAccount.getPassword());
        
        session = Session.getInstance(pop3Props, null);
        store = new POP3SSLStore(session, url);
        store.connect();
        
    }
    
    private void openFolder(String folderName) throws Exception {
        
        // Open the Folder
        folder = store.getDefaultFolder();
        
        folder = folder.getFolder(folderName);
        
        if (folder == null) {
            throw new Exception("Invalid folder");
        }
        
        // try to open read/write and if that fails try read-only
        try {
            
            folder.open(Folder.READ_WRITE);
            
        } catch (MessagingException ex) {
            
            folder.open(Folder.READ_ONLY);
            
        }
    }
    
    private void closeFolder() throws Exception {
        folder.close(false);
    }
    
    private int getMessageCount() throws Exception {
        return folder.getMessageCount();
    }
    
    private int getNewMessageCount() throws Exception {
        return folder.getNewMessageCount();
    }
    
    private void disconnect() throws Exception {
        store.close();
    }
    
    private void printMessage(int messageNo) throws Exception {
        System.out.println("Getting message number: " + messageNo);
        
        Message m = null;
        
        try {
            m = folder.getMessage(messageNo);
            dumpPart(m);
        } catch (IndexOutOfBoundsException iex) {
            System.out.println("Message number out of range");
        }
    }
    
    private void printAllMessageEnvelopes() throws Exception {
        
        // Attributes & Flags for all messages ..
        Message[] msgs = folder.getMessages();
        
        // Use a suitable FetchProfile
        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);        
        folder.fetch(msgs, fp);
        
        for (int i = 0; i < msgs.length; i++) {
            System.out.println("--------------------------");
            System.out.println("MESSAGE #" + (i + 1) + ":");
            dumpEnvelope(msgs[i]);
            
        }
        
    }
    
    private void printAllMessages() throws Exception {
     
        // Attributes & Flags for all messages ..
        Message[] msgs = folder.getMessages();
        
        // Use a suitable FetchProfile
        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);        
        folder.fetch(msgs, fp);
        
        for (int i = 0; i < msgs.length; i++) {
            System.out.println("--------------------------");
            System.out.println("MESSAGE #" + (i + 1) + ":");
            dumpPart(msgs[i]);
        }
        
    
    }
    
    
    private static void dumpPart(Part p) throws Exception {
        if (p instanceof Message)
            dumpEnvelope((Message)p);
       
        String ct = p.getContentType();
        try {
            pr("CONTENT-TYPE: " + (new ContentType(ct)).toString());
        } catch (ParseException pex) {
            pr("BAD CONTENT-TYPE: " + ct);
        }
        
        /*
         * Using isMimeType to determine the content type avoids
         * fetching the actual content data until we need it.
         */
        if (p.isMimeType("text/plain")) {
            pr("This is plain text");
            pr("---------------------------");
            System.out.println((String)p.getContent());        
        } else {
            
            // just a separator
            pr("---------------------------");
            
        }
    }
    
    private static void dumpEnvelope(Message m) throws Exception {        
        pr(" ");
        Address[] a;
        // FROM
        if ((a = m.getFrom()) != null) {
            for (int j = 0; j < a.length; j++)
                pr("FROM: " + a[j].toString());
        }
        
        // TO
        if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
            for (int j = 0; j < a.length; j++) {
                pr("TO: " + a[j].toString());                
            }
        }
        
        // SUBJECT
        pr("SUBJECT: " + m.getSubject());
        
        // DATE
        Date d = m.getSentDate();
        pr("SendDate: " +
                (d != null ? d.toString() : "UNKNOWN"));
        

    }
    
    static String indentStr = "                                               ";
    static int level = 0;
    
    /**
     * Print a, possibly indented, string.
     */
    private static void pr(String s) {
        
        System.out.print(indentStr.substring(0, level * 2));
        System.out.println(s);
    }
   

	@Override
	public List<MailModelRepresentation> readMails() {
		List<MailModelRepresentation> mailsRepresentation = new ArrayList<MailModelRepresentation>();
		Message[] messages = null;
        try {
            this.connect();
            this.openFolder("INBOX");
            messages = this.folder.getMessages();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        if(messages == null) return mailsRepresentation;
        for (Message message : messages) {
			try {
				SimpleMailBean simpleMailBean = new SimpleMailBean();
				simpleMailBean.setSendDate(message.getSentDate());
				simpleMailBean.setAddressFrom(message.getFrom()[0].getType());
				simpleMailBean.setAddressTo(convertAddressToListOfString(message.getAllRecipients()));
				simpleMailBean.setContentType(message.getContentType());
				simpleMailBean.setSubject(message.getSubject());
				mailsRepresentation.add(simpleMailBean);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
        return mailsRepresentation;
	}
	private List<String> convertAddressToListOfString(Address ... addresses){
		List<String> stringResults = new ArrayList<String>();
		for (Address address : addresses) {
			stringResults.add(address.toString());
		}
		return stringResults;
	}
	
}
