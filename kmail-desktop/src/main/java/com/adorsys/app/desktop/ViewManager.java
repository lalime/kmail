/**
 * 
 */
package com.adorsys.app.desktop;

import java.io.IOException;
import java.util.Date;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.desktop.model.TableMailModel;

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
		mainStage.setResizable(false);
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
		showMailList();
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
	
	public void showMailList(){

        TableView<TableMailModel> mailTableView = new TableView<TableMailModel>();
        
        TableColumn<TableMailModel, String> mailFromColumn = new  TableColumn<TableMailModel, String>("From");
        TableColumn<TableMailModel, String> mailSubjectColumn =  new TableColumn<TableMailModel, String>("Subject");
        TableColumn<TableMailModel, String> mailDateColumn = new TableColumn<TableMailModel, String>("Date");
        
		mailFromColumn.setCellValueFactory(new PropertyValueFactory<TableMailModel, String>("from"));
		mailSubjectColumn.setCellValueFactory(new PropertyValueFactory<TableMailModel, String>("subject"));
		mailDateColumn.setCellValueFactory(new PropertyValueFactory<TableMailModel, String>("date"));
		
		mailTableView.getColumns().addAll(mailFromColumn,mailSubjectColumn,mailDateColumn);
		mailTableView.setPrefHeight(200);
		mailTableView.setPrefWidth(600);
		mailTableView.setMaxHeight(Double.MAX_VALUE);
		mailTableView.setMaxWidth(Double.MAX_VALUE);
		mailTableView.autosize();
		
		mailTableView.getItems().add(new TableMailModel("boris.waguia@adorsys.com", "welcome to kmail", new Date().toString()));
		showList(mailTableView );
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
	public static void setMainScreenAnchorPane(AnchorPane anchorPane){
		if(anchorPane == null || viewManager == null) throw new IllegalArgumentException("Null value is not required");
		viewManager.mainScreenAnchorPane = anchorPane;
	}
	
	private <T> void showList(TableView<T> tableView){
		viewManager.mainScreenAnchorPane.getChildren().clear();
		viewManager.mainScreenAnchorPane.getChildren().add(tableView);
	}
	
}
