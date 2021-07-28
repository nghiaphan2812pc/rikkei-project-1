package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;


public interface UserService {
	List<User> getAllUser(); 
	void saveUser(User user);
	User getUserById(long id);
	void deleteUser(long id);
}
