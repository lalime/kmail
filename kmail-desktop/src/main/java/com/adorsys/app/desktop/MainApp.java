package com.adorsys.app.desktop;

import javafx.application.Application;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {
	private static Logger LOG = LoggerFactory.getLogger(MainApp.class) ;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

	public void start(Stage stage) throws Exception {
		LOG.info("Starting Hello JavaFX and Maven demonstration application");
        KmailApplicationContextUtils.initApplicationContext();
        ViewManager.initViewManager(stage);
        ViewManager.getViewManager().showLoginScreen();
    }
}
