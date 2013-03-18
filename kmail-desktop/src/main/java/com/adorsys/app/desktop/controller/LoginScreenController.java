package com.adorsys.app.desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.desktop.ViewManager;

public class LoginScreenController
{
    private static final Logger log = LoggerFactory.getLogger(LoginScreenController.class);

    @FXML private TextField userNameField;
    @FXML private TextField passwordField;
    @FXML private Label messageLabel;

    public void onLogin() {

        String firstName = userNameField.getText();
        String lastName = passwordField.getText();

        StringBuilder builder = new StringBuilder();

        if (!StringUtils.isEmpty(firstName)) {
            builder.append(firstName);
        }

        if (!StringUtils.isEmpty(lastName)) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(lastName);
        }

        if (builder.length() > 0) {
			ViewManager.getViewManager().showHomepage();
        } else {
            log.debug("Neither first name nor last name was set, saying hello to anonymous person");
            messageLabel.setText("Hello mysterious person");
        }
    }

}
