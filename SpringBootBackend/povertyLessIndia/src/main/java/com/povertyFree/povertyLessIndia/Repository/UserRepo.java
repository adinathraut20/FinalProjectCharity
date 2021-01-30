package com.povertyFree.povertyLessIndia.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.Users;


@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {

	public Users findByEmailAndPassword(String email, String password);
	public Users findByEmail(String email);
	
}


