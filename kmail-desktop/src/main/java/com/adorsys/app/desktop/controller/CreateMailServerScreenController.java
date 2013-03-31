package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import com.adorsys.app.api.data.Protocol;
import com.adorsys.app.data.domain.MailServer;
import com.adorsys.app.desktop.KmailApplicationContextUtils;
import com.adorsys.app.desktop.ViewManager;

/**
 * 
 * @author w2b
 *
 */
public class CreateMailServerScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField hostNameTextField;

    @FXML
    private AnchorPane newMailServerScreen;

    @FXML
    private TextField portTextField;

    @FXML
    private ComboBox<Protocol> protocolTextField;

    @FXML
    private Button saveButton;
/*
    @FXML
    private ComboBox<Protocol> serverTypeTextField;*/


    @FXML
    void onCancelButtonClicked(MouseEvent event) {
    	ViewManager.getViewManager().showMailList(
    			KmailApplicationContextUtils.getAppUserMailDataService().findReceivedMails());
    }
    
    private MailServer getMailServer(){
    	MailServer mailServer = new MailServer();
    	mailServer.setHostName(hostNameTextField.getText());
    	mailServer.setPort(portTextField.getText());
    	mailServer.setProtocol(protocolTextField.getValue());
    	return mailServer;
    }
    @FXML
    void onSaveButtonClicked(MouseEvent event) {
    	MailServer mailServer = getMailServer();
    	KmailApplicationContextUtils.getMailServerDataService().save(mailServer);
    	ViewManager.getViewManager().showMailServerList(
    			KmailApplicationContextUtils.getMailServerDataService().findAll());
    }

    @FXML
    void initialize() {
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'createMailServer.fxml'.";
        assert hostNameTextField != null : "fx:id=\"hostNameTextField\" was not injected: check your FXML file 'createMailServer.fxml'.";
        assert newMailServerScreen != null : "fx:id=\"newMailServerScreen\" was not injected: check your FXML file 'createMailServer.fxml'.";
        assert portTextField != null : "fx:id=\"portTextField\" was not injected: check your FXML file 'createMailServer.fxml'.";
        assert protocolTextField != null : "fx:id=\"protocolTextField\" was not injected: check your FXML file 'createMailServer.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'createMailServer.fxml'.";
        protocolTextField.getItems().addAll(Protocol.IMAP,Protocol.POP3,Protocol.SMTP);
    }

}
