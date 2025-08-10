package com.tcs.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.main.entity.User;
import com.tcs.main.repository.UserRepository;
import com.tcs.main.service.LoginUser;
import com.tcs.main.service.RegisterUser;

@Service
public class LoginUserImpl implements LoginUser{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean loginUserService(String email, String password) {
		
		User user = userRepository.findByEmail(email);
		
		if(email.equals(user.getEmail()) && password.equals(password)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public User userDetails(String email) {
		User user = userRepository.findByEmail(email);		
		return user;
	}

	

}
