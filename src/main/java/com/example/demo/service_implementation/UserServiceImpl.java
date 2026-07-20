package com.example.demo.service_implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo ur; 
	
	
	private List<User>users = new ArrayList<>();
	
	public UserServiceImpl() {
		this.users.add(new User(1, "ram", "ram@gamil.com", "1234"));
		this.users.add(new User(2, "shyam", "shyam@gamil.com", "12343"));
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return this.ur.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		// TODO Auto-generated method stub
		for(User nextUser : users) {
			if(nextUser.getId() == id) {
				return ur.findById(id); 
			}
		}
		return null;
	}

	@Override
	public User insertUser(User newUser) {
		// TODO Auto-generated method stub
		User createdUser = this.ur.save(newUser);
		return createdUser;
	}

	public User deleteUserById(int id) {
		for(User u : users) {
			if(u.getId() == id) {
				ur.deleteById(id);
				return u; 
			}
		}
		return null; 
	}
	

}
