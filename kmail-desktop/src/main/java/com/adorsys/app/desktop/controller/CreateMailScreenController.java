package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.data.domain.AppUserMail;
import com.adorsys.app.data.domain.Mail;
import com.adorsys.app.desktop.KmailApplicationContextUtils;
import com.adorsys.app.desktop.ViewManager;
import com.adorsys.app.service.SimpleMailSender;


public class CreateMailScreenController {

	private Logger LOGGER = LoggerFactory.getLogger(CreateMailScreenController.class);
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ccField;

    @FXML
    private Button discardButton;

    @FXML
    private Button draftButton;

    @FXML
    private HTMLEditor mailEditor;

    @FXML
    private ComboBox<String> mailFromComboBox;

    @FXML
    private TextField mailToField;

    @FXML
    private AnchorPane newMailScreen;

    @FXML
    private Button sendButton;

    @FXML
    private TextField subjectField;


    @FXML
    void onDiscardButtonMouseClicked(MouseEvent event) {
    	Mail mailInEdition = getMailInEdition();
    	saveInDraftIfItIsANewMail(mailInEdition);
    	ViewManager.getViewManager().showMailList();
    }

    private void saveInDraftIfItIsANewMail(Mail mailInEdition) {
    	if(mailInEdition == null) return;
    	boolean isANewMail = isANewMail(mailInEdition);
    	if(isANewMail){
    		saveInDraft(mailInEdition);
    	}
	}

	private void saveInDraft(MailModelRepresentation mailInEdition) {
		AppUserMail appUserMail = (AppUserMail) mailInEdition;
		appUserMail.setInDraft(true);
		//appUserMail.setMail(mailInEdition);
		KmailApplicationContextUtils.getAppUserMailDataService().save(appUserMail);
	}

	private boolean isANewMail(Mail mailInEdition) {
		return mailInEdition.getId() == null;
	}

	@FXML
    void onDraftButtonMouseClicked(MouseEvent event) {
		
    	ViewManager.getViewManager().showMailList();
    }

    @FXML
    void onMailFromComboBoxClicked(MouseEvent event) {
    }

    @FXML
    void onSendButtonMouseClicked(MouseEvent event) {
    	Mail mail = getMailInEdition();
    	
    	LOGGER.info(mail.toString());
    	
    	MailAccountModelRepresentation mailAccount = KmailApplicationContextUtils.getMailAccountDataService().findByHostName("smtp.gmail.com");
    	if(mailAccount == null){
    		LOGGER.error("No Mail Account Found With that hostName" );
    		return ;
    	}
    	
    	try{
    		SimpleMailSender mailSender = new SimpleMailSender(mailAccount);
    		mailSender.sendMail(mail);
    	}catch(Exception exception){
    		LOGGER.error(exception.getMessage(),exception);
    	}
    	ViewManager.getViewManager().showMailList();
    }

	private Mail getMailInEdition() {
		String mailFrom = mailFromComboBox.getSelectionModel().getSelectedItem();
    	String mailTo = mailToField.getText();
    	String mailsInCC = ccField.getText();
    	String subject = subjectField.getText();
    	String htmlText = mailEditor.getHtmlText();
    	
    	StringTokenizer stringTokenizer = new StringTokenizer(mailTo);
    	List<String> mailsTo = new ArrayList<String>();
    	while (stringTokenizer.hasMoreElements()) {
			mailsTo.add(stringTokenizer.nextToken());
		}
    	
    	Mail mail = new Mail();
    	mail.setAddressFrom(Arrays.asList(mailFrom));
    	mail.setBody(htmlText);
    	mail.setSubject(subject);
    	mail.setSendDate(new Date());
    	mail.setAddressTo(mailsTo);
		return mail;
	}

    @FXML
    void initialize() {
        assert ccField != null : "fx:id=\"ccField\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert discardButton != null : "fx:id=\"discardButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert draftButton != null : "fx:id=\"draftButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert mailEditor != null : "fx:id=\"mailEditor\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert mailFromComboBox != null : "fx:id=\"mailFromComboBox\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert mailToField != null : "fx:id=\"mailToField\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert newMailScreen != null : "fx:id=\"newMailScreen\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert subjectField != null : "fx:id=\"subjectField\" was not injected: check your FXML file 'createMailScreen.fxml'.";


        this.mailFromComboBox.getItems().clear();
        this.mailFromComboBox.getItems().addAll(Arrays.asList("","boris.waguia@adorsys.com","b.waguia@gmail.com"));
    }

}
