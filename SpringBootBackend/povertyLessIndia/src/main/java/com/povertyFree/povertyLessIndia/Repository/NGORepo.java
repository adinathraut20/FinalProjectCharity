package com.povertyFree.povertyLessIndia.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.povertyFree.povertyLessIndia.dto.NGO;


@Repository
public interface NGORepo extends CrudRepository<NGO, Integer> {

	public NGO findByEmailAndPassword(String email, String password);
	public NGO findByEmailIgnoreCase(String email);
	NGO findByNgoId(int ngoId);
}
