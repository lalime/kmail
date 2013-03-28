/**
 * 
 */
package com.adorsys.app.desktop.controller;

import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.data.MailServerModelRepresentation;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author w2b
 *
 */
public class TableAccountModel {
	private SimpleStringProperty id = new SimpleStringProperty();
	private SimpleStringProperty userName = new SimpleStringProperty();
	private SimpleStringProperty password = new SimpleStringProperty();
	private SimpleStringProperty mailServer = new SimpleStringProperty();
	
	public TableAccountModel(Long id, String userName,MailServerModelRepresentation mailModel){
		super();
		setId(id);
		setUserName(userName);
		setMailServer(mailModel.toString());
	}
	public String getId(){
		return id.get();
	}
	public void setId(Long id){
		this.id.set(id.toString());
	}
	public String getUserName(){
		return userName.get();
	}
	public void setUserName(String userName){
		this.userName.set(userName);
	}
	public String getPassword(){
		return password.get();
	}
	public void setPassword(String password){
		this.password.set(password);
	}
	public String getMailServer(){
		return mailServer.get();
	}
	public void setMailServer(String mailServer){
		this.mailServer.set(mailServer);
	}
}
