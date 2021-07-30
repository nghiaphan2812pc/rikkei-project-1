package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;


public interface UserService {
	List<User> getAllUser(); 
	void saveUserRegister(User user);
	void saveUserUpdate(User user);
	User getUserById(long id);
	void deleteUser(long id);
}
