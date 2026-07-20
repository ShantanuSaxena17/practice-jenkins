package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.LoginCredentials;
import com.example.demo.dtos.TokenResponse;
import com.example.demo.jwt.JwtUtils;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserRepo ur;
	
	
	@PostMapping("/signup")
	public User signup(@Valid @ModelAttribute User newUser) {
		System.out.println(newUser);
		return this.us.insertUser(newUser);  
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenResponse> login(@ModelAttribute LoginCredentials credentials) {
		
		User foundUser = this.ur.findByEmail(credentials.getEmail());
		
		if(foundUser!=null && foundUser.getPassword().equals(credentials.getPassword())) {
			//Generate token 
			String token = JwtUtils.generateToken(foundUser.getId(), foundUser.getName());
			
			TokenResponse response = new TokenResponse(token); 
			
			return ResponseEntity.ok(response); 
		}
		
		//throw new RuntimeException("User not found"); 
		
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
	}
}
