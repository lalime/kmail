package com.adorsys.app.desktop.controller;

import java.net.URL;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;


public class HomeScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> actionComboBox;

    @FXML
    private Ellipse ellipse;

    @FXML
    private Text justTryItText;

    @FXML
    private Text kmailText;

    @FXML
    private Tab mailListTab;

    @FXML
    private TableView<?> mailListTableView;

    @FXML
    private TabPane mainTabPane;

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
    void onMailListTabClosed(Event event) {
    }

    @FXML
    void onMailListTabSelectionChanged(Event event) {
    }

    @FXML
    void onMouseEntered(MouseEvent event) {
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
    void onReceivedLabelMailClicked(MouseEvent event) {
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
        assert justTryItText != null : "fx:id=\"justTryItText\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert kmailText != null : "fx:id=\"kmailText\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailListTab != null : "fx:id=\"mailListTab\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mailListTableView != null : "fx:id=\"mailListTableView\" was not injected: check your FXML file 'homeScreen.fxml'.";
        assert mainTabPane != null : "fx:id=\"mainTabPane\" was not injected: check your FXML file 'homeScreen.fxml'.";
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
    }
    private static String initialReceivedMailLabelText ;
    private static String initialSendedMailLabelText ;
    private static String initialTrashMailLabelText ;
    
}
