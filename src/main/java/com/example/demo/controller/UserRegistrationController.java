package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationController {
	
	private UserService userService;
	
	
	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}



//	@PostMapping("/registration")
//	public ResponseEntity<UserRegistrationDto> userPost(@RequestBody UserRegistrationDto userDto) {
//		//TODO: process POST request
//	  UserRegistrationDto savedUser = userService.addUser(userDto);
//		
//		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//	}
//	
//   @PostMapping("/registration")
//   public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
//	   userService.save(registrationDto);
//       return ;
//   }
	@PostMapping("/register")
    public User registerUser(@RequestBody UserRegistrationDto registrationDto) {
        return userService.save(registrationDto);
    }
   
}
