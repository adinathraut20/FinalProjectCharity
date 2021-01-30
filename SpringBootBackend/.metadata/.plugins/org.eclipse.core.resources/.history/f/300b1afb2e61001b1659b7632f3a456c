package com.povertyFree.povertyLessIndia.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue
	private int userId;
	private String uFname;
	private String uLname;
	@Column( unique=true)
	private String email;
	private String password;
	private String contact;
	private String city;
	private String state;
	private String address;
	
	
	public Users() {}


	public Users(int userId) {
		super();
		this.userId = userId;
	}


	public Users(int userId, String uFname, String uLname, String email, String password, String contact, String city,
			String state, String address) {
		super();
		this.userId = userId;
		this.uFname = uFname;
		this.uLname = uLname;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.city = city;
		this.state = state;
		this.address = address;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getuFname() {
		return uFname;
	}


	public void setuFname(String uFname) {
		this.uFname = uFname;
	}


	public String getuLname() {
		return uLname;
	}


	public void setuLname(String uLname) {
		this.uLname = uLname;
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


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", uFname=" + uFname + ", uLname=" + uLname + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + ", city=" + city + ", state=" + state
				+ ", address=" + address + "]";
	}


	

}
