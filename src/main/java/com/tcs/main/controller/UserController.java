package com.tcs.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.main.entity.User;
import com.tcs.main.service.LoginUser;
import com.tcs.main.service.RegisterUser;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	RegisterUser registerUser;
	
	@Autowired
	LoginUser loginUser;

	@GetMapping("register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("regForm")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		else {
			try {
				registerUser.addUser(user);
				model.addAttribute("successMsg", "Registered SuccessFully");
				return "login";
			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:/error";
			}
		}
	}
	
	@GetMapping("login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("loginForm")
	public String loginUser(@ModelAttribute("user") User user, Model model) {
		
		boolean isAuthenticated = loginUser.loginUserService(user.getEmail(), user.getPassword());
		
		if(isAuthenticated) {
			User authenticatedUser = loginUser.userDetails(user.getEmail());
			model.addAttribute("authenticatedUser", authenticatedUser);
			
			return "profile";
		}
		else {
			model.addAttribute("errorMsg", "Invalid Username or Password");
			return "login";
		}
	}
	
	
}
