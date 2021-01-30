package com.povertyFree.povertyLessIndia.Service;

import com.povertyFree.povertyLessIndia.dto.Users;

public interface EmailService {

	void sendEmail(String email, int otp);
	
	boolean sendEmailandPassword(String email, String password);
	
	boolean sendMessageContactUs(Users user);
	
	
}
