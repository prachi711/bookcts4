package com.cts.Entity;

import javax.persistence.Entity;

@Entity
public class User {

	
	private String userName;
	
	private String name;
	
	

	private String password;
	
	private String dob;
	
	private String address;

	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String name, String password, String dob, String address) {
		super();
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.address = address;
	}
	
	
	
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", password=" + password + ", dob=" + dob
				+ ", address=" + address + "]";
	}
	
	
	
}
