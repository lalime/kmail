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
    private TextField receivingPortTextfield;

    @FXML
    private ComboBox<Protocol> receivingProtocolTexfield;
    

    @FXML
    private TextField sendingPortTextfield;

    @FXML
    private ComboBox<Protocol> sendingProtocolTextfield;

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
    	mailServer.setReceivingPort(receivingPortTextfield.getText());
    	mailServer.setReceivingProtocol(receivingProtocolTexfield.getValue() );
    	mailServer.setSendingPort(sendingPortTextfield.getText());
    	mailServer.setSendingProtocol(sendingProtocolTextfield.getValue());
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
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'createMailServer.fxml'.";
        
        assert receivingPortTextfield != null : "fx:id=\"receivingPortTextfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
        assert receivingProtocolTexfield != null : "fx:id=\"receivingProtocolTexfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
        assert sendingPortTextfield != null : "fx:id=\"sendingPortTextfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
        assert sendingProtocolTextfield != null : "fx:id=\"sendingProtocolTextfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
        
        sendingProtocolTextfield.getItems().clear();
        sendingProtocolTextfield.getItems().addAll(Protocol.SMTP);
        receivingProtocolTexfield.getItems().clear();
        receivingProtocolTexfield.getItems().addAll(Protocol.POP3,Protocol.IMAP);
    }
    
}
