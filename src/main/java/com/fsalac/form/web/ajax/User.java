package com.fsalac.form.web.ajax;

import com.fasterxml.jackson.annotation.JsonView;

public class User {

	@JsonView(Views.Public.class)
	private String username;

	private String password;

	@JsonView(Views.Public.class)
	private String email;

	@JsonView(Views.Public.class)
	private String phone;

	private String address;
	
	public User(){
		super();
	}

	public User(String username, String password, String email, String phone, String address){
		this.username = username;
		this.password = password;
		this.setEmail(email);
		this.phone = phone;
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//getters, setters and contructors
}