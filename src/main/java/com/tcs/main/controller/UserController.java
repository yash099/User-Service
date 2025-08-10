package com.tcs.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcs.main.entity.User;

@Controller
@RequestMapping("/")
public class UserController {

	@GetMapping("register")
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@GetMapping("login")
	public String loginPage() {
		return "login";
	}
}
