package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/user")
//@Controller
public class UserController {
	
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<UserDto> userPost(@RequestBody UserDto userDto) {
		//TODO: process POST request
	  UserDto savedUser = userService.addUser(userDto);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	

}
