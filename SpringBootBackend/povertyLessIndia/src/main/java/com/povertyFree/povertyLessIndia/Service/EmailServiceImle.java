package com.povertyFree.povertyLessIndia.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.povertyFree.povertyLessIndia.dto.Users;


@Service
public class EmailServiceImle implements EmailService {
	@Autowired
	 private JavaMailSender javaMailSender;
	 
	private String companyEmailAddress="xyzdhule@gmail.com";
	
	    
	    public  EmailServiceImle(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;	        
	    }

	    @Async
	    public void sendEmail(String email, int otp) throws MailException {
	        SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setTo(email);
	        mail.setFrom(companyEmailAddress);
	        mail.setSubject("Complete Registration!");
	        mail.setText("To confirm your account, "
	        		 +"Enter the Given OTP " +otp);
	       
	        javaMailSender.send(mail);
	     
	    }

	    @Async
		public boolean sendEmailandPassword (String email, String password)throws MailException {
			SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setTo(email);
	        mail.setFrom(companyEmailAddress);
	        mail.setSubject("Forgot Password");
	        mail.setText("Paasword for your id :"+ email + "  is : "
	        		  +password);

	        javaMailSender.send(mail);
			return false;
		}

	    @Async
		public boolean sendMessageContactUs(Users user)throws MailException{
	    	SimpleMailMessage mail = new SimpleMailMessage();
	        mail.setTo(user.getEmail());
	        mail.setFrom(companyEmailAddress);
	        mail.setSubject(user.getuLname());
	        mail.setText(user.getuFname()+ " : Thank You For Contacting Us our Management will soon contact with you :).");
	       
	        javaMailSender.send(mail);
	        
	        mail.setTo("adinathraut20@gmail.com", "shubhamdashpute1@gmail.com");
	        mail.setFrom(companyEmailAddress);
	        mail.setSubject("Query Generated");
	        mail.setText(user.getEmail()+" \n"+ user.getuFname()+ " has contacted our Compacy please Contact him/her.");
	        javaMailSender.send(mail);
			return true;
		}

		

}
