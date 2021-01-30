package com.povertyFree.povertyLessIndia.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.States;



public interface CitiesRepo extends CrudRepository<Cities, Integer> {

	public List<Cities> findByState(States stateId);
	public Cities findByCityName(String cityName);
}
