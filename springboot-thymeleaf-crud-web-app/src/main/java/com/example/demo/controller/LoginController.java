package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/login")
	public String gotoLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
//	@PostMapping("/login")
//	public String login(@ModelAttribute("user") User user) {
//		
//		return "login";
//	}
}
