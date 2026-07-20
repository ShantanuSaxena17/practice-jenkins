package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserProfile;
import com.example.demo.models.User;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService us; 
	
	@GetMapping
	public List<User> getAllUsers() {
		return this.us.getAllUsers();
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Object> getUsersById(@PathVariable int id) {
//		User foundUser = this.us.getUserById(id); 
//		if(foundUser!=null) {
//			return ResponseEntity.ok(foundUser); 
//		}
//		return ResponseEntity.notFound().build(); 
//	}
	
	@GetMapping("/profile")
	public ResponseEntity<UserProfile> getProfile(HttpServletRequest request){
		Integer id = (Integer) request.getAttribute("id");
		Optional<User> foundUser = this.us.getUserById(id);
		User newUser = foundUser.get();
		UserProfile profile = new UserProfile(newUser.getId(), newUser.getName(), newUser.getEmail());
		
		return ResponseEntity.ok(profile); 
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable int id) {
		User u = this.us.deleteUserById(id); 
		if(u==null) {
			System.out.println("No user found with id: " + id);
		}else {
			System.out.println("user deleted with id: " + id);
		}
	}
}
