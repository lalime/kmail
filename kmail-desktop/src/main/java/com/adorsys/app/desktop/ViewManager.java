/**
 * 
 */
package com.adorsys.app.desktop;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author w2b
 *
 */
public class ViewManager {
	
	private Stage mainStage ;
	
	private final String HOME_SCREEN_PAGE_NAME = "/fxml/homeScreen.fxml";
	private final String LOGIN_SCREEN_NAME = "/fxml/loginScreen.fxml";
	
	private static ViewManager viewManager ;
	
	private ViewManager(){
		
	}
    private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);
    
    public static ViewManager getViewManager(){
    	if(viewManager == null) throw new NullPointerException("This view Manager Has not been Initialize Yet ! " +
    			"Please make sure a ViewManager.initViewManager(mainStage), is call in the MainApp.java ");
    	return viewManager;
    }
	public static void initViewManager(Stage mainStage) {
		if(mainStage ==null) throw new IllegalArgumentException("The Main stage Is Required! Null Value is not accepted");
		viewManager  = new ViewManager();
		mainStage.setResizable(false);
		viewManager.mainStage = mainStage;
	}
	
	public void showHomepage() throws IOException{
        LOGGER.debug("Loading FXML for main view from: {}", HOME_SCREEN_PAGE_NAME);
		VBox homePage = FXMLLoader.load(getClass().getResource(HOME_SCREEN_PAGE_NAME));
		Scene scene = new Scene(homePage, 800,400);
		showScene(scene, "Welcome To Kmail - Kmail");
	}
	
	public void showLoginScreen() throws IOException{
		LOGGER.debug("Loading FXML for Login view from : {}",LOGIN_SCREEN_NAME);
		Parent parentNode= FXMLLoader.load(getClass().getResource(LOGIN_SCREEN_NAME));
		Scene loginScreenScene= new Scene(parentNode,400,300);
		loginScreenScene.getStylesheets().add("/styles/styles.css");
		showScene(loginScreenScene,"Log In - Kmail");
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
}
