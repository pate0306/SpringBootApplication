/**
 * 
 * @author Parth
 * @date 2020-01-14
 * @description UserDetailRequestModel class use to handle the user request. It will use to
 *              convert the incoming JSON into Java Class
 */
package com.webappdevelopment.model.request;

public class UserDetailRequestModel {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
