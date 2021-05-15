package com.povertyFree.povertyLessIndia.dto;

public class Message {
	
	String message;
	boolean flag;
	boolean session;
	Users user;
	NGO ngo;
	MaterialDonation md;
	Admins admin;
	
	public Message(String message, boolean flag) {
		super();
		this.message = message;
		this.flag = flag;
	}

	public Message(String message, boolean flag, boolean session) {
		super();
		this.message = message;
		this.flag = flag;
		this.session = session;
	}

	public Message(String message, boolean flag, Users user) {
		super();
		this.message = message;
		this.flag = flag;
		this.user = user;
	}

	public Message(String message, boolean flag, NGO ngo) {
		super();
		this.message = message;
		this.flag = flag;
		this.ngo = ngo;
	}

	public Message(String message, boolean flag, MaterialDonation md) {
		super();
		this.message = message;
		this.flag = flag;
		this.md = md;
	}

	public Message(String message, boolean flag, Admins admin) {
		super();
		this.message = message;
		this.flag = flag;
		this.admin = admin;
	}

	public Message(String message, boolean flag, boolean session, Users user, NGO ngo, MaterialDonation md,
			Admins admin) {
		super();
		this.message = message;
		this.flag = flag;
		this.session = session;
		this.user = user;
		this.ngo = ngo;
		this.md = md;
		this.admin = admin;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public NGO getNgo() {
		return ngo;
	}

	public void setNgo(NGO ngo) {
		this.ngo = ngo;
	}

	public MaterialDonation getMd() {
		return md;
	}

	public void setMd(MaterialDonation md) {
		this.md = md;
	}

	public Admins getAdmin() {
		return admin;
	}

	public void setAdmin(Admins admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", flag=" + flag + ", session=" + session + ", user=" + user + ", ngo="
				+ ngo + ", md=" + md + ", admin=" + admin + "]";
	}
	
	
	
	
	
	
}