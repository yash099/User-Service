package com.tcs.main.service;

import org.springframework.stereotype.Service;

import com.tcs.main.entity.User;

@Service
public interface RegisterUser {
	
	public void addUser(User user);

}
