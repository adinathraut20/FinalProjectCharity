package com.povertyFree.povertyLessIndia.Service;

import java.util.List;

import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.States;
import com.povertyFree.povertyLessIndia.dto.Users;



public interface UserService {
	
boolean AddUser(Users user);
	
	List<Users> getAllUsers();
	
	Users UserValidate(Users user);
	
	boolean deleteUser(int id);
	
	MaterialDonation addMaterialDonation(MaterialDonation mDonation);
	
	List<States> getAllStates();

	List<Cities> getCitites(int stateId);
	
	Users userEmailCheckAlreadyPresent(String email);
	
	MaterialDonation uploadImage( String uImage,int donationId ); 
	
	List<MaterialDonation> getUserDonationStatus(int id);
	
	List<MaterialDonation> getUserDonationHistory(int id);
	
	Users getUserDetails(int id);
	
	Users updateUser(Users user);
	
}
