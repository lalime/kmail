package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adorsys.app.api.data.ApplicationUserMailModelRepresentation;
import com.adorsys.app.api.data.MailAccountModelRepresentation;
import com.adorsys.app.api.data.MailServerModelRepresentation;
import com.adorsys.app.desktop.KmailApplicationContextUtils;
import com.adorsys.app.desktop.ViewManager;
import com.adorsys.app.desktop.model.TableMailModel;


public class HomeScreenController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeScreenController.class);
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> actionComboBox;

    @FXML
    private Ellipse ellipse;

    @FXML
    private Text kmailText;
    
    @FXML
    private MenuItem listMailAccountMenuItem;

    @FXML
    private MenuItem listMailServersMenuItem;
    
    private TableColumn<TableMailModel, String> mailDateColumn;

    private TableColumn<TableMailModel, String> mailFromColumn;

    private TableColumn<TableMailModel, String> mailSubjectColumn;

    private TableView<TableMailModel> mailTableView;
    
    @FXML
    private MenuItem mailAccountMenuItem;

    @FXML
    private MenuItem mailServerMenuItem;
    
    @FXML
    private AnchorPane mainContainer;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuFIle;

    @FXML
    private Menu menuHelp;

    @FXML
    private Menu menuInsert;

    @FXML
    private Button newMailBtn;

    @FXML
    private Label receivedMailLabel;

    @FXML
    private TextField searchField;

    @FXML
    private Label sendedMailLabel;

    @FXML
    private Label trashLabel;
    
    @FXML
    void onListMailAccountMenuItemActionPerformed(ActionEvent event) {
    	List<MailAccountModelRepresentation> mailsAccounts = KmailApplicationContextUtils.getMailAccountDataService().findAll();
    	ViewManager.getViewManager().showMailAccountList(mailsAccounts);
    }

    @FXML
    void onListMailServersMenuItemActionPerformed(ActionEvent event) {
    	List<MailServerModelRepresentation> mailServers = KmailApplicationContextUtils.getMailServerDataService().findAll();
    	ViewManager.getViewManager().showMailServerList(mailServers);
    }

    @FXML
    void onMailAccountMenuItemValidation(Event event) {
    	LOGGER.info("Create New Mail Account");
    	ViewManager.getViewManager().showCreateMailAccountScreen();
    }

    @FXML
    void onMailServerMenuItemValidation(Event event) {
    	ViewManager.getViewManager().showCreateNewMailServerScreen();
    }
    
    @FXML
    void onMouseEnteredMailLabel(MouseEvent event) {
    	Label lab = (Label) event.getSource();
    	lab.setCursor(Cursor.OPEN_HAND);
    }

    @FXML
    void onMouseExitedMailLabel(MouseEvent event) {
    	Label lab = (Label) event.getSource();
    	lab.setCursor(Cursor.NONE);
    }

    @FXML
    void onNewMailButtonClicked(MouseEvent event) {
    	ViewManager.getViewManager().showCreateMailScreen();
    }

    @FXML
    void onReceivedLabelMailClicked(MouseEvent event) {
    	LOGGER.info("Searching All Received Mails...");
    	List<ApplicationUserMailModelRepresentation> receivedMails = KmailApplicationContextUtils.getAppUserMailDataService().findReceivedMails();
    	ViewManager.getViewManager().showMailList(receivedMails);
    }


    @FXML
    void onSearchFieldKeyPressed(KeyEvent event) {

    }

    @FXML
    void onSearchFieldKeyReleased(KeyEvent event) {
    	String searchText = searchField.getText();
    	if(searchText == null || "".equals(searchText)){
    		searchText = "";
    	}else {
    		searchText = "   ("+searchText+")";
    	}
		this.receivedMailLabel.setText(""+initialReceivedMailLabelText+""+searchText+"");
    }

    @FXML
    void onSendedMailLabelClicked(MouseEvent event) {
    	LOGGER.info("Searching for sended Mails ...");
    	List<ApplicationUserMailModelRepresentation> sendedMails = KmailApplicationContextUtils.getAppUserMailDataService().findSendedMails();
    	ViewManager.getViewManager().showMailList(sendedMails);
    }

    @FXML
    void onTrashedMailLabelClicked(MouseEvent event) {
    	LOGGER.info("Searching for trashed Mails...");
    	List<ApplicationUserMailModelRepresentation> trashedMails = KmailApplicationContextUtils.getAppUserMailDataService().findTrashedMails();
    	ViewManager.getViewManager().showMailList(trashedMails);
    }

    @FXML
    void initialize() {
        assert actionComboBox != null : "fx:id=\"actionComboBox\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert ellipse != null : "fx:id=\"ellipse\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert kmailText != null : "fx:id=\"kmailText\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailAccountMenuItem != null : "fx:id=\"mailAccountMenuItem\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailServerMenuItem != null : "fx:id=\"mailServerMenuItem\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailDateColumn != null : "fx:id=\"mailActionColumn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailFromColumn != null : "fx:id=\"mailFromColumn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailSubjectColumn != null : "fx:id=\"mailSubjectColumn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailTableView != null : "fx:id=\"mailTableView\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mainContainer != null : "fx:id=\"mainContainer\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuFIle != null : "fx:id=\"menuFIle\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuHelp != null : "fx:id=\"menuHelp\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuInsert != null : "fx:id=\"menuInsert\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert newMailBtn != null : "fx:id=\"newMailBtn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert receivedMailLabel != null : "fx:id=\"receivedMailLabel\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert sendedMailLabel != null : "fx:id=\"sendedMailLabel\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert trashLabel != null : "fx:id=\"trashLabel\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert listMailAccountMenuItem != null : "fx:id=\"listMailAccountMenuItem\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert listMailServersMenuItem != null : "fx:id=\"listMailServersMenuItem\" was not injected: check your FXML file 'homeScreen.fxml'.";
        
        initialReceivedMailLabelText = this.receivedMailLabel.getText();
        initialSendedMailLabelText = this.sendedMailLabel.getText();
        initialTrashMailLabelText = this.trashLabel.getText();
        
        ViewManager.setMainScreenAnchorPane(mainContainer);

    }
    public  void upadateView(AnchorPane anchorPane){
    	this.mainContainer.getChildren().clear();
    	this.mainContainer.getChildren().add(anchorPane);
    }
    
    private static String initialReceivedMailLabelText ;
    private static String initialSendedMailLabelText ;
    private static String initialTrashMailLabelText ;
}
