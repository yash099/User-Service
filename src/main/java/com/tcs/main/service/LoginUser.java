package com.tcs.main.service;

import org.springframework.stereotype.Service;

import com.tcs.main.entity.User;

@Service
public interface LoginUser {

	public boolean loginUserService(String email, String password);
	
	public User userDetails(String email);
}
