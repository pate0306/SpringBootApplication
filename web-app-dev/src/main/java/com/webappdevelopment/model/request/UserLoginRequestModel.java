/**
 * 
 * @author Parth
 * @date 2020-01-12
 * @description UserLoginRequestModel class use to handle user login request
 */
package com.webappdevelopment.model.request;

public class UserLoginRequestModel {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
