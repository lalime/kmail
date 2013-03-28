/**
 * 
 */
package com.adorsys.app.desktop.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author w2b
 *
 */
public class TableServerModel {
	private SimpleStringProperty id = new SimpleStringProperty();
	private SimpleStringProperty protocol =  new SimpleStringProperty();
	private SimpleStringProperty hostName = new SimpleStringProperty() ;
	private SimpleStringProperty port = new SimpleStringProperty();
	
	public TableServerModel(Long id,String protocol,String hostName,String port){
		super();
		setId(id);
		setProtocol(protocol);
		setHostName(hostName);
		setPort(port);
	}
	
	public String getId(){
		return id.get();
	}
	public void setId(Long id){
		this.id.set(id.toString());
	}
	public String getProtocol(){
		return protocol.get();
	}
	public void setProtocol(String protocol){
		this.protocol.set(protocol);
	}
	public String getHostName(){
		return hostName.get();
	}
	public void setHostName(String hostName){
		this.hostName.set(hostName);
	}
	public String getPort(){
		return port.get();
	}
	public void setPort(String port){
		this.port.set(port);
	}
	
}
