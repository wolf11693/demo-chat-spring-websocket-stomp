package com.org.ra.model;

import java.io.Serializable;

public class Messaggio implements Serializable {

	private static final long serialVersionUID = -8104494178701669693L;

	private String body;
	
	public Messaggio() {
		super();
	}
	
	public Messaggio(String body) {
		super();
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}