package com.povertyFree.povertyLessIndia.Repository;

import org.springframework.data.repository.CrudRepository;

import com.povertyFree.povertyLessIndia.dto.States;

public interface StatesRepo extends CrudRepository<States, Integer> {

	public States findByStateName(String stateName);
}