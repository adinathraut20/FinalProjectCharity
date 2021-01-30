package com.povertyFree.povertyLessIndia.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admins {

	@Id
	@GeneratedValue
	private int adminId;
	private String uFname;
	private String uLname;
	@Column( unique=true)
	private String email;
	private String password;
	private String contact;
	
	public Admins() {
		super();
	}

	public Admins(int adminId) {
		super();
		this.adminId = adminId;
	}

	public Admins(int adminId, String uFname, String uLname, String email, String password, String contact) {
		super();
		this.adminId = adminId;
		this.uFname = uFname;
		this.uLname = uLname;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	@Override
	public String toString() {
		return "Admins [adminId=" + adminId + ", uFname=" + uFname + ", uLname=" + uLname + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + "]";
	}
	
	
	
	
	
}
