package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	// display list of user
	@GetMapping("/")
	public String viewListUser(Model model) {
		model.addAttribute("listUser",userService.getAllUser());
		return "user";
	}
	@GetMapping("/showNewUserForm")
	// create model attribute to bind form data
	public String ShowNewUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// save user to db
		userService.saveUser(user);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "update_user";
	}
	@GetMapping("/deleteUser/{id}")
	public String deteleUser(@PathVariable(value = "id")long id){
		userService.deleteUser(id);
		return "redirect:/";
	}
}
