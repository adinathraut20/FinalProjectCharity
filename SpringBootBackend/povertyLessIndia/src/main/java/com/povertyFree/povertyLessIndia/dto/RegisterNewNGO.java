package com.povertyFree.povertyLessIndia.dto;



public class RegisterNewNGO {

	private int ngoId;	
	private String ngoName;
	private String email;
	private String password;
	private String contact;
	private String regNo;
	private String state;
	private String city;
	private String location;
	private String address;
	public RegisterNewNGO() {
		super();
	}
	public RegisterNewNGO(int ngoId) {
		super();
		this.ngoId = ngoId;
	}
	public RegisterNewNGO(int ngoId, String ngoName, String email, String password, String contact, String regNo,
			String state, String city, String location, String address) {
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
		return "RegisterNewNGO [ngoId=" + ngoId + ", ngoName=" + ngoName + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + ", regNo=" + regNo + ", state=" + state + ", city=" + city + ", location="
				+ location + ", address=" + address + "]";
	}
	
	
}
