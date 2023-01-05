package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@RestController
public class PostController{
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public ResponseEntity<User> postData(@RequestBody User user){
		userRepository.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
}