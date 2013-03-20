package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;


public class CreateMailScreenController {

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
    private ComboBox<?> mailFromComboBox;

    @FXML
    private ComboBox<?> mailToComboBox;

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
    void onMailFromComboBoxClicked(MouseEvent event) {
    }

    @FXML
    void onMailToComboBoxClicked(MouseEvent event) {
    }

    @FXML
    void onSendButtonMouseClicked(MouseEvent event) {
    }

    @FXML
    void initialize() {
        assert discardButton != null : "fx:id=\"discardButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert draftButton != null : "fx:id=\"draftButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert mailEditor != null : "fx:id=\"mailEditor\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert mailFromComboBox != null : "fx:id=\"mailFromComboBox\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert mailToComboBox != null : "fx:id=\"mailToComboBox\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert newMailScreen != null : "fx:id=\"newMailScreen\" was not injected: check your FXML file 'createMailScreen.fxml'.";
        assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'createMailScreen.fxml'.";


    }

}
