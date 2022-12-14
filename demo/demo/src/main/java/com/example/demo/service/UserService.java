package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;
import com.example.demo.persistence.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity create(final UserEntity userEntity) {   // userEntity db?? ????
		if(userEntity == null || userEntity.getUserId() == null) {
			throw new RuntimeException("Invalid arguments");
		}
		final String userId = userEntity.getUserId();
		if(userRepository.existsByUserId(userId)) {
			throw new RuntimeException("Id already exists");
		}
		
		return userRepository.save(userEntity);
	}
	
	public UserEntity getByCredentials(final String userId, final String password) { 
			//final PasswordEncoder encoder) {
		/*final UserEntity originalUser = userRepository.findByUserId(userId);
		
		if(originalUser != null && encoder.matches(password, originalUser.getPassword())) {
			return originalUser;
		}
		return null;*/
		
		return userRepository.findByUserId(userId);
	}
}
