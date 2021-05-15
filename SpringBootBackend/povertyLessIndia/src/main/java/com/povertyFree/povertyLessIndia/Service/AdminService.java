package com.povertyFree.povertyLessIndia.Service;

import java.util.List;

import com.povertyFree.povertyLessIndia.dto.Admins;
import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.Users;

public interface AdminService {
	
	Admins checkAdmin(Admins admin);
	
	List<Cities> getAllCities();
	
	List<MaterialDonation> getAllMaterialDonationList();
	
	List<NGO> getAllNGOList();
	
	List<Users> getAllUsersList();
	
	boolean abortMaterialDonation(int id);
	
	boolean deleteMaterialDonation(int id) throws Exception;

}