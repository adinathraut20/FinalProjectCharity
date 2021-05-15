package com.povertyFree.povertyLessIndia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "MaterialDonation")
public class MaterialDonation {

	@Id
	@GeneratedValue
	private int donationId;	
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "catergoryId")
	private Categories category;
	private int quantity;
	private String contact;
	@ManyToOne
	@JoinColumn(name = "stateId")
	private States state;
	@ManyToOne
	@JoinColumn(name = "cityId")
	private Cities city;
	private String address;
	private String location;
	private String status;
	private String uImage;
	private String proof;
	private String time;
	private String date1;
	@ManyToOne
	@JoinColumn(name = "ngoId")
	private NGO ngo;
	
	public MaterialDonation() {
		super();
	}
	public MaterialDonation(int donationId) {
		super();
		this.donationId = donationId;
	}
	public MaterialDonation(int donationId, Users user, Categories category, int quantity, String contact, States state,
			Cities city, String address, String location, String status, String uImage, String proof, String time,
			String date1, NGO ngo) {
		super();
		this.donationId = donationId;
		this.user = user;
		this.category = category;
		this.quantity = quantity;
		this.contact = contact;
		this.state = state;
		this.city = city;
		this.address = address;
		this.location = location;
		this.status = status;
		this.uImage = uImage;
		this.proof = proof;
		this.time = time;
		this.date1 = date1;
		this.ngo = ngo;
	}
	public int getDonationId() {
		return donationId;
	}
	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public NGO getNgo() {
		return ngo;
	}
	public void setNgo(NGO ngo) {
		this.ngo = ngo;
	}
	@Override
	public String toString() {
		return "MaterialDonation [donationId=" + donationId + ", user=" + user + ", category=" + category
				+ ", quantity=" + quantity + ", contact=" + contact + ", state=" + state + ", city=" + city
				+ ", address=" + address + ", location=" + location + ", status=" + status + ", uImage=" + uImage
				+ ", proof=" + proof + ", time=" + time + ", date1=" + date1 + ", ngo=" + ngo + "]";
	}
	
	
	
}