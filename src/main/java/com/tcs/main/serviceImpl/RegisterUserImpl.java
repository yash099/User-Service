package com.tcs.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.main.entity.User;
import com.tcs.main.repository.UserRepository;
import com.tcs.main.service.RegisterUser;

@Service
public class RegisterUserImpl implements RegisterUser{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	
}
