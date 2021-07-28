package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if(optional.isPresent()) {
			user = optional.get();
		}else {
			throw new RuntimeException("User not found by id: "+id);
		}
		return user;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}
	
	
}