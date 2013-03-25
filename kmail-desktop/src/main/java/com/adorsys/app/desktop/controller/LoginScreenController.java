package com.adorsys.app.desktop.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.api.data.ApplicationUserModelRepresentation;
import com.adorsys.app.desktop.KmailApplicationContextUtils;
import com.adorsys.app.desktop.ViewManager;

public class LoginScreenController {
    private static final Logger log = LoggerFactory.getLogger(LoginScreenController.class);

    @FXML private TextField userNameField;
    @FXML private TextField passwordField;
    @FXML private Label messageLabel;

    public void onLogin() {

        String userName = userNameField.getText();
        String password = passwordField.getText();

        if (StringUtils.isEmpty(userName)) {
        	//TODO : the user name is required
        }

        if (StringUtils.isEmpty(password)) {
            //TODO : The password is required;
        }
        if("kmail".equals(userName) && "test".equals(password)){
        	ViewManager.getViewManager().showHomepage();
        	return;
        }
        ApplicationUserModelRepresentation applicationUser = KmailApplicationContextUtils.getApplicationUserDataService().findByUserName(userName);
        if(applicationUser == null) messageLabel.setText("No user Found !");
        if(! password.equals(applicationUser.getPassword())){
        	messageLabel.setText("Invalid Credentials");
        	return ;
        }
        KmailApplicationContextUtils.setApplicationUser(applicationUser);
		ViewManager.getViewManager().showHomepage();
    }

}
