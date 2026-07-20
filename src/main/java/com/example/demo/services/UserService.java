package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.User; 

public interface UserService {
	public List<User> getAllUsers(); 
	public Optional<User> getUserById(int id);
	public User insertUser(User us); 
	public User deleteUserById(int id); 
}
