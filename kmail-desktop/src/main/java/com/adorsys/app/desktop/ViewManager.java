/**
 * 
 */
package com.adorsys.app.desktop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.data.MailServerModelRepresentation;
import com.adorsys.app.data.domain.MailAccount;
import com.adorsys.app.data.domain.MailServer;
import com.adorsys.app.desktop.controller.CreateMailScreenController;
import com.adorsys.app.desktop.controller.TableAccountModel;
import com.adorsys.app.desktop.model.TableMailModel;
import com.adorsys.app.desktop.model.TableServerModel;

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
	private final String CREATE_MAIL_SERVER_SCREEN_NAME = "/fxml/createMailServerScreen.fxml";
	private final String CREATE_MAIL_ACCOUNT_SCREEN = "/fxml/createMailAccountScreen.fxml";
	
	private static ViewManager viewManager ;
	
	private VBox homeScreen ;
	private AnchorPane createMailScreen;
	private Parent loginScreen ;
	private AnchorPane createNewMailScreen ;
	private AnchorPane mainScreenAnchorPane ;
	private AnchorPane createMailAccountScreen;
    private ComboBox<MailServerModelRepresentation> mailServerComboBox;
	
	
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
		
		LOGGER.debug("Loading FXML for Login view from : {}",viewManager.CREATE_MAIL_SERVER_SCREEN_NAME);
		viewManager.createNewMailScreen = FXMLLoader.load(ViewManager.class.getResource(viewManager.CREATE_MAIL_SERVER_SCREEN_NAME));

		LOGGER.debug("Loading FXML for Login view from : {}",viewManager.CREATE_MAIL_ACCOUNT_SCREEN);
		viewManager.createMailAccountScreen = FXMLLoader.load(ViewManager.class.getResource(viewManager.CREATE_MAIL_ACCOUNT_SCREEN));
	}
	
	public void showHomepage() {
		Scene scene = new Scene(viewManager.homeScreen, 800,400);
		showScene(scene, "Welcome To Kmail - Kmail");
		showMailList(null);
	}
	
	public void showLoginScreen() {
		Scene loginScreenScene= new Scene(viewManager.loginScreen,400,300);
		loginScreenScene.getStylesheets().add("/styles/styles.css");
		showScene(loginScreenScene,"Log In - Kmail");
	}
	
	public void showCreateMailScreen(){
		LOGGER.info(viewManager.mainScreenAnchorPane.toString());
		CreateMailScreenController.updateMailAccountList(KmailApplicationContextUtils.getMailAccountDataService().findAll());
		viewManager.createMailScreen.setPrefHeight(viewManager.mainScreenAnchorPane.getPrefHeight());
		viewManager.createMailScreen.setPrefWidth(viewManager.mainScreenAnchorPane.getPrefWidth());
		replaceMainScreenContain(viewManager.createMailScreen);
	}
	
	public void showMailList(List<ApplicationUserMailModelRepresentation> data){

        final TableView<TableMailModel> mailTableView = new TableView<TableMailModel>();
        
        TableColumn<TableMailModel, String> mailFromColumn = new  TableColumn<TableMailModel, String>("From");
        TableColumn<TableMailModel, String> mailSubjectColumn =  new TableColumn<TableMailModel, String>("Subject");
        TableColumn<TableMailModel, String> mailDateColumn = new TableColumn<TableMailModel, String>("Date");
        
		mailFromColumn.setCellValueFactory(new PropertyValueFactory<TableMailModel, String>("from"));
		mailSubjectColumn.setCellValueFactory(new PropertyValueFactory<TableMailModel, String>("subject"));
		mailDateColumn.setCellValueFactory(new PropertyValueFactory<TableMailModel, String>("date"));
		
		EventHandler<Event> enventHandler =  new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				TableMailModel selectedItem = mailTableView.getSelectionModel().getSelectedItem();
				System.out.println("mouse clicked on the table : "+selectedItem.toString());
			}
		};
		mailTableView.setOnMouseClicked( enventHandler);
		mailTableView.getColumns().addAll(mailFromColumn,	mailSubjectColumn,mailDateColumn);
		if(data == null || data.isEmpty()){
			mailTableView.getItems().add(new TableMailModel("boris.waguia@adorsys.com", "welcome to kmail", new Date().toString()));			
		}else {
			mailTableView.getItems().addAll(convertToTableMailModels(data));
		}
		showList(mailTableView );
	}
	
	public void showMailServerList(List<MailServerModelRepresentation> mailServers) {
		TableView<TableServerModel> serverTableViews = new TableView<TableServerModel>();
		TableColumn<TableServerModel, String> idColumn = new TableColumn<TableServerModel, String>("No");
		TableColumn<TableServerModel, String> protocolColumn = new TableColumn<TableServerModel, String>("Protocol");
		TableColumn<TableServerModel, String> hostNameColumn = new TableColumn<TableServerModel, String>("Host Name");
		TableColumn<TableServerModel, String> portColumn= new TableColumn<TableServerModel, String>("Port");
		
		idColumn.setCellValueFactory(new PropertyValueFactory<TableServerModel, String>("id"));
		protocolColumn.setCellValueFactory(new PropertyValueFactory<TableServerModel, String>("protocol"));
		hostNameColumn.setCellValueFactory(new PropertyValueFactory<TableServerModel, String>("hostName"));
		portColumn.setCellValueFactory(new PropertyValueFactory<TableServerModel, String>("port"));
		
		serverTableViews.getColumns().addAll(idColumn,protocolColumn,hostNameColumn,portColumn);
		if(mailServers == null ||  mailServers.isEmpty()){
			serverTableViews.getItems().add(new TableServerModel(new Long(0),"pop3", "pop.gmail.com", "995"));
		}else {
			serverTableViews.getItems().addAll(convertToServerMailModel(mailServers));
		}
		showList(serverTableViews );
	}
	
	public void showCreateNewMailServerScreen(){
    	LOGGER.info("Create New Mail Server.");
		replaceMainScreenContain(viewManager.createNewMailScreen);
	}
	private void replaceMainScreenContain(AnchorPane anchorPane) {
		viewManager.mainScreenAnchorPane.getChildren().clear();
		viewManager.mainScreenAnchorPane.getChildren().add(anchorPane);
		anchorPane.autosize();
	}
	
	public void showCreateMailAccountScreen(){
		LOGGER.info("Create a new mail Account");
		List<MailServerModelRepresentation> allMailServers = KmailApplicationContextUtils.getMailServerDataService().findAll();
		if(allMailServers != null){
			viewManager.mailServerComboBox.getItems().clear();
			viewManager.mailServerComboBox.getItems().addAll(allMailServers);
		}
		replaceMainScreenContain(viewManager.createMailAccountScreen);
	}
	public void showMailAccountList(List<MailAccountModelRepresentation> mailAccounts){
		TableView<TableAccountModel> mailAccountTableView = new TableView<TableAccountModel>();
		
		TableColumn<TableAccountModel,String> idColumn = new TableColumn<TableAccountModel, String>("No");
		TableColumn<TableAccountModel, String> userNameColumn = new TableColumn<TableAccountModel, String>("User Name");
		TableColumn<TableAccountModel, String> mailServerColumn = new TableColumn<TableAccountModel, String>("Mail Server");
		
		idColumn.setCellValueFactory(new PropertyValueFactory<TableAccountModel, String>("id"));
		userNameColumn.setCellValueFactory(new PropertyValueFactory<TableAccountModel, String>("userName"));
		mailServerColumn.setCellValueFactory(new PropertyValueFactory<TableAccountModel, String>("mailServer"));
		
		mailAccountTableView.getColumns().addAll(idColumn,userNameColumn,mailServerColumn);
		
		mailAccountTableView.getItems().addAll(convertToMailAccountModel(mailAccounts));
		showList(mailAccountTableView);
	}
	private Collection<TableMailModel> convertToTableMailModels(List<ApplicationUserMailModelRepresentation> receivedMails) {
		Collection<TableMailModel> data = new ArrayList<TableMailModel>();
    	for (ApplicationUserMailModelRepresentation appUserMail : receivedMails) {
			MailModelRepresentation mail = appUserMail.getMail();
			data.add(new TableMailModel(mail.getAddressFrom().toString(), mail.getSubject(),mail.getSendDate().toString()));
		}
		return data;
	}
	private Collection<TableServerModel> convertToServerMailModel(List<MailServerModelRepresentation> dataToConvert){
		Collection<TableServerModel> convertedData = new ArrayList<TableServerModel>();
		for (MailServerModelRepresentation mailServerM : dataToConvert) {
			MailServer mailServer = (MailServer) mailServerM;
			convertedData.add(new TableServerModel(mailServer.getId(),mailServer.getSendingProtocol().toString(), mailServer.getSendingHostName(), mailServer.getSendingPort()));
		}
		return convertedData;
	}
	private Collection<TableAccountModel> convertToMailAccountModel(List<MailAccountModelRepresentation> dataToConvert){
		Collection<TableAccountModel> convertedData = new ArrayList<TableAccountModel>();
		for (MailAccountModelRepresentation mailAccountM : dataToConvert) {
			MailAccount mailAccount = (MailAccount) mailAccountM;
			convertedData.add(new TableAccountModel(mailAccount.getId(), mailAccount.getUserName(), mailAccount.getMailServer()));
		}
		return convertedData;
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
	public static void setMailServerComboBox(ComboBox<MailServerModelRepresentation> comboBox){
		if(comboBox == null) throw new IllegalArgumentException("The Combobox Is Required !");
		viewManager.mailServerComboBox = comboBox;
	}
	private <T> void showList(TableView<T> tableView){
		tableView.setPrefHeight(200);
		tableView.setPrefWidth(600);
		tableView.setMaxHeight(Double.MAX_VALUE);
		tableView.setMaxWidth(Double.MAX_VALUE);
		tableView.autosize();
		viewManager.mainScreenAnchorPane.getChildren().clear();
		viewManager.mainScreenAnchorPane.getChildren().add(tableView);
	}
	
}

