package com.cdac.pojo;

public class Users {

	
	private String name;
	private String userName;
	private String password;
	private String email;
	private String city;
	
	public Users() {
			//dfult ctor
	}
	
	
	public Users(String name, String userName, String password, String email, String city) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.city = city;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Users [name=" + name + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", city=" + city + "]";
	}
	
	
	
}
