package com.example.demo.service;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.entity.User;

public interface UserService {
    public User save(UserRegistrationDto registrationDto);
}
