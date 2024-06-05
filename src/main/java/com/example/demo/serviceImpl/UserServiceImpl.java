package com.example.demo.serviceImpl;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
//	@Autowired
	private UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}



	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getEmail(),
				registrationDto.getPassword(),
				registrationDto.getCreatedDate(),
				Arrays.asList(new Role("ROLE USER"))
				);
		return userRepository.save(user);
	}
     
	

}
