package com.provertyless.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.provertyless.demo.dto.User;
import com.provertyless.demo.repository.UserRepo;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public void insertUser(User user) {
		userRepo.save(user);
		return;
	}

	@Override
	public User getUser(int userid) {
		
		return userRepo.findById(userid).get();
	}

}
