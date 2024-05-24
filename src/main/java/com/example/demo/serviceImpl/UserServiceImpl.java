package com.example.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
     
	private UserRepository userRepository;
	
	@Override
	public UserDto addUser(UserDto userDto) {

		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setUserName(userDto.getUserName());
		
		User savedUser = userRepository.save(user);
		
		UserDto savedUserDto = new UserDto();
		savedUser.setId(savedUser.getId());
		savedUser.setEmail(savedUser.getEmail());
		savedUser.setCreatedDate(savedUserDto.getCreatedDate());
		savedUser.setName(savedUserDto.getName());
		savedUser.setUserName(savedUserDto.getUserName());
		
		
		return savedUserDto;
	}

}
