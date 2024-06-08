package com.example.demo.service;

import java.util.Set;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;

public interface UserService {
//    public User save(UserRegistrationDto registrationDto);
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	public User getUser(String username);
	public void deleteUser(Long  userId);
}
