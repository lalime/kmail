package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import com.adorsys.app.desktop.ViewManager;
import com.adorsys.app.desktop.model.TableMailModel;


public class HomeScreenController {

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
    
    private TableColumn<TableMailModel, String> mailDateColumn;

    private TableColumn<TableMailModel, String> mailFromColumn;

    private TableColumn<TableMailModel, String> mailSubjectColumn;

    private TableView<TableMailModel> mailTableView;
    
    @FXML
    private AnchorPane mainContainer;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu menuEdit;

    @FXML
    private Menu menuFIle;

    @FXML
    private Menu menuHelp;

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
    	ViewManager.getViewManager().showMailList();
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
    }

    @FXML
    void onTrashedMailLabelClicked(MouseEvent event) {
    }

    @FXML
    void initialize() {
        assert actionComboBox != null : "fx:id=\"actionComboBox\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert ellipse != null : "fx:id=\"ellipse\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert kmailText != null : "fx:id=\"kmailText\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailDateColumn != null : "fx:id=\"mailActionColumn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailFromColumn != null : "fx:id=\"mailFromColumn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailSubjectColumn != null : "fx:id=\"mailSubjectColumn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailTableView != null : "fx:id=\"mailTableView\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mainContainer != null : "fx:id=\"mainContainer\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuEdit != null : "fx:id=\"menuEdit\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuFIle != null : "fx:id=\"menuFIle\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert menuHelp != null : "fx:id=\"menuHelp\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert newMailBtn != null : "fx:id=\"newMailBtn\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert receivedMailLabel != null : "fx:id=\"receivedMailLabel\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert searchField != null : "fx:id=\"searchField\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert sendedMailLabel != null : "fx:id=\"sendedMailLabel\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert trashLabel != null : "fx:id=\"trashLabel\" was not injected: check your FXML file 'homeScreen.fxml'.";

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
