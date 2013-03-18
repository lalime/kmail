/**
 * 
 */
package com.adorsys.app.desktop;

import java.io.IOException;
import java.util.Set;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @author w2b
 * I use this class, to centralize the management and the navigation among views.
 * I also, load resource, on startup, to avoid any surprising views issues at runtime.
 */
public class ViewManager {
	
	private Stage mainStage ;
	
	private final String HOME_SCREEN_PAGE_NAME = "/fxml/homeScreen.fxml";
	private final String LOGIN_SCREEN_NAME = "/fxml/loginScreen.fxml";
	
	private final String CREATE_MAIL_SCREEN = "/fxml/createMailScreen.fxml";
	
	private static ViewManager viewManager ;
	
	private VBox homeScreen ;
	private AnchorPane createMailScreen;
	private Parent loginScreen ;
	
	private AnchorPane mainScreenAnchorPane ;
	private ViewManager(){
		
	}
    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);
    
    public static ViewManager getViewManager(){
    	if(viewManager == null) throw new NullPointerException("This view Manager Has not been Initialize Yet ! " +
    			"Please make sure a ViewManager.initViewManager(mainStage), is call in the MainApp.java ");
    	return viewManager;
    }
	public static void initViewManager(Stage mainStage) throws IOException {
		if(mainStage ==null) throw new IllegalArgumentException("The Main stage Is Required! Null Value is not accepted");
		viewManager  = new ViewManager();
		mainStage.setResizable(true);
		viewManager.mainStage = mainStage;
		
		LOGGER.debug("Loading FXML for main view from: {}", viewManager.HOME_SCREEN_PAGE_NAME);
		viewManager.homeScreen = FXMLLoader.load(ViewManager.class.getResource(viewManager.HOME_SCREEN_PAGE_NAME));

		LOGGER.debug("Loading FXML for Login view from : {}",viewManager.LOGIN_SCREEN_NAME);
		viewManager.loginScreen = FXMLLoader.load(ViewManager.class.getResource(viewManager.LOGIN_SCREEN_NAME));

		LOGGER.debug("Loading FXML for Login view from : {}",viewManager.CREATE_MAIL_SCREEN);
		viewManager.createMailScreen = FXMLLoader.load(ViewManager.class.getResource(viewManager.CREATE_MAIL_SCREEN));
	}
	
	public void showHomepage() {
		Scene scene = new Scene(viewManager.homeScreen, 800,400);
		showScene(scene, "Welcome To Kmail - Kmail");
	}
	
	public void showLoginScreen() {
		Scene loginScreenScene= new Scene(viewManager.loginScreen,400,300);
		loginScreenScene.getStylesheets().add("/styles/styles.css");
		showScene(loginScreenScene,"Log In - Kmail");
	}
	
	public void showCreateMailScreen(){
		viewManager.mainScreenAnchorPane.getChildren().clear();
		LOGGER.info(viewManager.mainScreenAnchorPane.toString());
		viewManager.createMailScreen.setPrefHeight(viewManager.mainScreenAnchorPane.getPrefHeight());
		viewManager.createMailScreen.setPrefWidth(viewManager.mainScreenAnchorPane.getPrefWidth());
		viewManager.mainScreenAnchorPane.getChildren().add(viewManager.createMailScreen);
		viewManager.createMailScreen.autosize();
	}
	private void showScene(Scene scene,String stageTitle){
		getStage().setScene(scene);
		if(stageTitle!= null) {
			getStage().setTitle(stageTitle);
		}
		getStage().show();
        LOGGER.debug("Showing "+stageTitle);
	}
	private Stage getStage(){
		return viewManager.mainStage;
	}
	private void setStage(Stage stage){
		viewManager.mainStage = stage;
	}
	public static void setMainScreenAnchorPane(AnchorPane anchorPane){
		if(anchorPane == null || viewManager == null) throw new IllegalArgumentException("Null value is not required");
		viewManager.mainScreenAnchorPane = anchorPane;
	}
}
