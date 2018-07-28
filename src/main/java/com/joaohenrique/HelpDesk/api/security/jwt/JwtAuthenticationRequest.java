package com.joaohenrique.HelpDesk.api.security.jwt;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	public JwtAuthenticationRequest() {
		super();
	}

	public JwtAuthenticationRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
