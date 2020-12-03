package com.provertyless.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Donation")
public class Donation {
	
	@Id
	@GeneratedValue
	private int donationId;
	private String category;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;
	private String contact;
//	@OneToOne
//	@JoinColumn(name = "cityId")
	private String state;
	private String city;
	private String address;
	private double price;
	private int seatNo;
	private String status;
	private String uImage;
	private String proof;
	public int getDonationId() {
		return donationId;
	}
	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getuImage() {
		return uImage;
	}
	public void setuImage(String uImage) {
		this.uImage = uImage;
	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	public Donation(int donationId) {
		super();
		this.donationId = donationId;
	}
	public Donation() {
		super();
	}
	public Donation(int donationId, String category, String contact, String state, String city, String address,
			double price, int seatNo, String status, String uImage, String proof) {
		super();
		this.donationId = donationId;
		this.category = category;
		this.contact = contact;
		this.state = state;
		this.city = city;
		this.address = address;
		this.price = price;
		this.seatNo = seatNo;
		this.status = status;
		this.uImage = uImage;
		this.proof = proof;
	}
	@Override
	public String toString() {
		return "Donation [donationId=" + donationId + ", category=" + category + ", contact=" + contact + ", state="
				+ state + ", city=" + city + ", address=" + address + ", price=" + price + ", seatNo=" + seatNo
				+ ", status=" + status + ", uImage=" + uImage + ", proof=" + proof + "]";
	}
	
	
	
	
	

	
	
	
	
}
