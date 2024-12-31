package com.book.bean;

public class NewUser 
{
	String firstname;
	String lastname;
	String username;
	String password;
	String email;
	String mobile_no;
	String gender;
	
	public NewUser() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public NewUser(String firstname, String lastname, String username, String password,
			String email, String mobile_no, String gender) 
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile_no = mobile_no;
		this.gender = gender;
	}
	
	public NewUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public NewUser(String username) {
		super();
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() 
	{
		return "NewUser [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ","
				+ " password="+ password + ", email=" + email + ", mobile_no=" + mobile_no + ", gender=" + gender + "]";
	}
	

}
