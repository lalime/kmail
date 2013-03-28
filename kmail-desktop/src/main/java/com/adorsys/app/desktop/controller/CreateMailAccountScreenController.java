package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.api.data.MailServerModelRepresentation;
import com.adorsys.app.data.domain.MailAccount;
import com.adorsys.app.data.domain.MailServer;
import com.adorsys.app.desktop.KmailApplicationContextUtils;
import com.adorsys.app.desktop.ViewManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * @author w2b
 *
 */
public class CreateMailAccountScreenController {
	
	private Logger LOGGER = LoggerFactory.getLogger(CreateMailAccountScreenController.class);
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

    @FXML
    private PasswordField confirmPasswordTextField;

    @FXML
    private ComboBox<MailServerModelRepresentation> mailServerComboBox;

    @FXML
    private AnchorPane newMailAccountScreen;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button saveButton;

    @FXML
    private TextField userNameTextField;


    @FXML
    void onCancelButtonClicked(MouseEvent event) {
    	ViewManager.getViewManager().showMailList(
    			KmailApplicationContextUtils.getAppUserMailDataService().findReceivedMails());
    }

    @FXML
    void onSaveButtonClicked(MouseEvent event) {
    	MailAccount mailAccount = getMailAccount();
    	KmailApplicationContextUtils.getMailAccountDataService().save(mailAccount);
    	ViewManager.getViewManager().showMailAccountList(
    			KmailApplicationContextUtils.getMailAccountDataService().findAll());
    }
    
    private MailAccount getMailAccount(){
    	MailAccount mailAccount = new MailAccount();
    	mailAccount.setUserName(userNameTextField.getText());
    	mailAccount.setPassword(passwordTextField.getText());
    	mailAccount.setMailServer(mailServerComboBox.getValue());
    	return mailAccount;
    }

    @FXML
    void initialize() {
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'createMailAccountScreen.fxml'.";
        assert confirmPasswordTextField != null : "fx:id=\"confirmPasswordTextField\" was not injected: check your FXML file 'createMailAccountScreen.fxml'.";
        assert mailServerComboBox != null : "fx:id=\"mailServerComboBox\" was not injected: check your FXML file 'createMailAccountScreen.fxml'.";
        assert newMailAccountScreen != null : "fx:id=\"newMailAccountScreen\" was not injected: check your FXML file 'createMailAccountScreen.fxml'.";
        assert passwordTextField != null : "fx:id=\"passowordTextField\" was not injected: check your FXML file 'createMailAccountScreen.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'createMailAccountScreen.fxml'.";
        assert userNameTextField != null : "fx:id=\"userNameTextField\" was not injected: check your FXML file 'createMailAccountScreen.fxml'.";
        
        ViewManager.setMailServerComboBox(mailServerComboBox);
        mailServerComboBox.getItems().addAll(KmailApplicationContextUtils.getMailServerDataService().findAll());

    }

}
