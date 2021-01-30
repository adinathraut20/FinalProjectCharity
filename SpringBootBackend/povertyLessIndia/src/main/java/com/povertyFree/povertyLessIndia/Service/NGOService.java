package com.povertyFree.povertyLessIndia.Service;

import java.util.List;

import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.RegisterNewNGO;

public interface NGOService {

	MaterialDonation donationAccept(int donateId ,int ngoId);
	
	NGO checkNGO(NGO ngo);
	
	boolean registerNGO(RegisterNewNGO ngo);
	
	NGO checkNGOEmail(String email);
	
	NGO getNGO(NGO ngo);
	
	List<MaterialDonation> getNGONotification(Cities cityId,String status);
	
	List<MaterialDonation> getNGOAcceptedDonation(NGO ngo);
	
	List<MaterialDonation> getNGODonationHistory(int ngoId);
	
	MaterialDonation uploadImageNGO(String filePath,int donateId);
	
	
	
}
