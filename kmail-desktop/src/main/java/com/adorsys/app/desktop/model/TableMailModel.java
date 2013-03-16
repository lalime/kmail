/**
 * 
 */
package com.adorsys.app.desktop.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author w2b
 *
 */
public class TableMailModel {
	private SimpleStringProperty from = new SimpleStringProperty();
	private SimpleStringProperty subject = new SimpleStringProperty();
	private SimpleStringProperty date= new SimpleStringProperty();
	public TableMailModel(String from,
			String subject, String date) {
		super();
		setFrom(from);
		setSubject(subject);
		setDate(date);
	}
	public String getFrom() {
		return from.get();
	}
	public void setFrom(String from) {
		this.from.set(from);
	}
	public String getSubject() {
		return subject.get();
	}
	public void setSubject(String subject) {
		this.subject.set(subject);
	}
	public String getDate() {
		return date.get();
	}
	public void setDate(String date) {
		this.date.set(date);
	}
}
