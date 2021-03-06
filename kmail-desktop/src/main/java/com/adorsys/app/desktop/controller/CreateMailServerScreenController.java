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
    private TextField hostNameTextfield;

    @FXML
    private AnchorPane newMailServerScreen;


    @FXML
    private TextField receivingHostNameTextField;
    
    @FXML
    private TextField sendingHostNameTextField;
    
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
    	mailServer.setSendingHostName(sendingHostNameTextField.getText());
    	mailServer.setReceivingHostName(receivingHostNameTextField.getText());
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
    	 assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
         assert receivingHostNameTextField != null : "fx:id=\"receivingHostNameTextField\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
         assert receivingPortTextfield != null : "fx:id=\"receivingPortTextfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
         assert receivingProtocolTexfield != null : "fx:id=\"receivingProtocolTexfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
         assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
         assert sendingHostNameTextField != null : "fx:id=\"sendingHostNameTextField\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
         assert sendingPortTextfield != null : "fx:id=\"sendingPortTextfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";
         assert sendingProtocolTextfield != null : "fx:id=\"sendingProtocolTextfield\" was not injected: check your FXML file 'createMailServerScreen.fxml'.";

        sendingPortTextfield.setText("25");
        sendingProtocolTextfield.getItems().clear();
        sendingProtocolTextfield.getItems().addAll(Protocol.smtp);
        sendingProtocolTextfield.setValue(Protocol.smtp);
        receivingProtocolTexfield.getItems().clear();
        receivingProtocolTexfield.getItems().addAll(Protocol.pop3,Protocol.imap);
    }
    
}
