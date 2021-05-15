package com.povertyFree.povertyLessIndia.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NGO")
public class NGO {
	
	@Id
	@GeneratedValue
	private int ngoId;	
	private String ngoName;
	@Column( unique=true)
	private String email;
	private String password;
	private String contact;
	private String regNo;
	@ManyToOne
	@JoinColumn(name = "stateId")
	private States state;
	@ManyToOne
	@JoinColumn(name = "cityId")
	private Cities city;
	private String location;
	
	private String address;
	
	public NGO() {
		super();
	}
	public NGO(int ngoId) {
		super();
		this.ngoId = ngoId;
	}
	public NGO(int ngoId, String ngoName, String email, String password, String contact, String regNo, States state,
			Cities city, String location, String address) {
		super();
		this.ngoId = ngoId;
		this.ngoName = ngoName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.regNo = regNo;
		this.state = state;
		this.city = city;
		this.location = location;
		this.address = address;
	}
	public int getNgoId() {
		return ngoId;
	}
	public void setNgoId(int ngoId) {
		this.ngoId = ngoId;
	}
	public String getNgoName() {
		return ngoName;
	}
	public void setNgoName(String ngoName) {
		this.ngoName = ngoName;
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
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public States getState() {
		return state;
	}
	public void setState(States state) {
		this.state = state;
	}
	public Cities getCity() {
		return city;
	}
	public void setCity(Cities city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "NGO [ngoId=" + ngoId + ", ngoName=" + ngoName + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + ", regNo=" + regNo + ", state=" + state + ", city=" + city + ", location="
				+ location + ", address=" + address + "]";
	}

	

}