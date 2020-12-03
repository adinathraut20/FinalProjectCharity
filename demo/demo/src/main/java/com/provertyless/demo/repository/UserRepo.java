package com.provertyless.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.provertyless.demo.dto.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
		
		
}
