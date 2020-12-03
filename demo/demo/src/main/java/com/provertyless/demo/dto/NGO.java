package com.provertyless.demo.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "NGO")
public class NGO {

	@Id
	@GeneratedValue
	private int ngoId;	
	private String ngoFname;
	private String ngoLname;
	private String email;
	private String password;
	private String contact;
	private String state;
	private String city;
	private String address;
	
	NGO(){}

	public NGO(int ngoId) {
		super();
		this.ngoId = ngoId;
	}

	public NGO(int ngoId, String ngoFname, String ngoLname, String email, String password, String contact, String state,
			String city, String address) {
		super();
		this.ngoId = ngoId;
		this.ngoFname = ngoFname;
		this.ngoLname = ngoLname;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.state = state;
		this.city = city;
		this.address = address;
	}

	public int getNgoId() {
		return ngoId;
	}

	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}

	public String getNgoFname() {
		return ngoFname;
	}

	public void setNgoFname(String ngoFname) {
		this.ngoFname = ngoFname;
	}

	public String getNgoLname() {
		return ngoLname;
	}

	public void setNgoLname(String ngoLname) {
		this.ngoLname = ngoLname;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "NGO [ngoId=" + ngoId + ", ngoFname=" + ngoFname + ", ngoLname=" + ngoLname + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + ", state=" + state + ", city=" + city
				+ ", address=" + address + "]";
	}
	
	
}
