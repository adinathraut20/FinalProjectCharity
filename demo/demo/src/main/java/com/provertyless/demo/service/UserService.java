package com.provertyless.demo.service;

import com.provertyless.demo.dto.User;

public interface UserService {

	void insertUser(User user);
	User getUser(int userid);
}
