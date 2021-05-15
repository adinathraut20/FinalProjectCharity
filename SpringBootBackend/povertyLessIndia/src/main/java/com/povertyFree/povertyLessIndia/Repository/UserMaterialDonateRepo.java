package com.povertyFree.povertyLessIndia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.Users;

@Repository
public interface UserMaterialDonateRepo extends CrudRepository<MaterialDonation, Integer> {

	@Modifying
	@Query("update MaterialDonation md  set md.ngo = ?1 where md.donationId = ?2")
	int setNgoForMaterialDonation(int ngo, int donationId);
	
	@Modifying
	@Query("update MaterialDonation md  set md.uImage = ?1 where md.donationId = ?2")
	int setUImageForMaterialDonation(String uImage, int donationId);
	
	List<MaterialDonation> findByUserAndStatus(Users user,String status);
	
	List<MaterialDonation> findByCityAndStatus(Cities city, String status);
	
	List<MaterialDonation> findByNgoAndStatus(NGO ngo, String status);

}