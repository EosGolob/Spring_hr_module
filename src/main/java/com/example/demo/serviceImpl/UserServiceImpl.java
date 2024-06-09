package com.example.demo.serviceImpl;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	


//	public UserServiceImpl(UserRepository userRepository) {
//	super();
//	this.userRepository = userRepository;
//}



	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User  local = this.userRepository.findByUserName(user.getUserName());
		if(local != null) {
			System.out.println("User is already there !!");
			throw new Exception("user already present");
		}else {
			for(UserRole ur:userRoles) {
				user.setCreatedDate();
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			local = this.userRepository.save(user);
		}
		return local;
	}


	@Override
	public User getUser(String username) {

		return this.userRepository.findByUserName(username);
	}


	@Override
	public void deleteUser(Long userId) {

		this.userRepository.deleteById(userId);
	}



//	@Override
//	public User save(UserRegistrationDto registrationDto) {
//		User user = new User(registrationDto.getFirstName(),
//				registrationDto.getLastName(),
//				registrationDto.getEmail(),
//				registrationDto.getPassword(),
//				registrationDto.getCreatedDate(),
//				Arrays.asList(new Role("ROLE USER"))
//				);
//		return userRepository.save(user);
//	}
//     
	

}
