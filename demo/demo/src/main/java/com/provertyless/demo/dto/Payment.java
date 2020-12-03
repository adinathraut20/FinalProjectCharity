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
@Table(name = "Payment")
public class Payment {
	
	@Id
	@GeneratedValue
	private int paymentId;
	private String Name;
	private String category;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;
	private String contact;
	private double amount;
	private String date;
	//private String time;
	private int accountNo;
	private String paymentMode;
	private int transactionId;
	private int cvv;
	private String expDate;
	private String status;

	
}