package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;


public class CreateMailScreenController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CreateMailScreenController.class);
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button discardButton;

    @FXML
    private Button draftButton;

    @FXML
    private HTMLEditor mailEditor;

    @FXML
    private AnchorPane newMailScreen;

    @FXML
    private Button sendButton;


    @FXML
    void onDiscardButtonMouseClicked(MouseEvent event) {
    }

    @FXML
    void onDraftButtonMouseClicked(MouseEvent event) {
    }

    @FXML
    void onSendButtonMouseClicked(MouseEvent event) {
    	String htmlText = mailEditor.getHtmlText();
    	LOGGER.info(htmlText);
    }

    @FXML
    void initialize() {
        assert discardButton != null : "fx:id=\"discardButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert draftButton != null : "fx:id=\"draftButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert mailEditor != null : "fx:id=\"mailEditor\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert newMailScreen != null : "fx:id=\"newMailScreen\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";


    }

}
