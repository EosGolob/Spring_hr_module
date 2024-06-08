package com.example.demo.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	


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
//	@PostMapping("/register")
//    public User registerUser(@RequestBody UserRegistrationDto registrationDto) {
//        return userService.save(registrationDto);
//    }
	
    @PostMapping
	public User createUser(@RequestBody User user ) throws Exception {
    	Set<UserRole> roles = new HashSet<>();
    	
    	Role role = new Role();
    	role.setRoleId(1L);
    	role.setRoleName("NORMAL");
    	
    	UserRole userRole = new UserRole();
    	userRole.setUser(user);
    	userRole.setRole(role);
    	
    	roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
    
    @GetMapping("/{userName}")
    public User getUser(@PathVariable ("userName") String userName) {
        return this.userService.getUser(userName);
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
    	this.userService.deleteUser(userId);
		return ResponseEntity.ok("user deleted successfully"); 
    }
    
    
    
}
