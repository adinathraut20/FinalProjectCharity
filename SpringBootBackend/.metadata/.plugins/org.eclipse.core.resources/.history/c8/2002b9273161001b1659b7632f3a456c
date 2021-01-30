package com.povertyFree.povertyLessIndia.Repository;

import org.springframework.data.repository.CrudRepository;

import com.povertyFree.povertyLessIndia.dto.Admins;

public interface AdminRepo extends CrudRepository<Admins, Integer> {
	
	Admins findByEmailAndPassword(String email, String password);

}
