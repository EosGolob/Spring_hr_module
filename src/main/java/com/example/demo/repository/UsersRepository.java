package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OurUsers;
import com.example.demo.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<OurUsers, Integer> {
  
	Optional<OurUsers> findByEmail(String email);
 

}
