package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.UserEntity;
import com.example.demo.security.TokenProvider;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	//private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	// 사용자 등록 -> 백엔드 테스트용
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
		try {
			UserEntity user = UserEntity.builder()
					.id(userDTO.getId())
					.userId(userDTO.getUserId())
					.userName(userDTO.getUserName())
					//.password(passwordEncoder.encode(userDTO.getPassword()))
					.password(userDTO.getPassword())
					.build();
			
			// 서비스로 db에 저장
			UserEntity registeredUser = userService.create(user);
			UserDTO responseUserDTO = UserDTO.builder()
					.id(registeredUser.getId())
					.userId(registeredUser.getUserId())
					.userName(registeredUser.getUserName())
					.build();
			
			return ResponseEntity.ok().body(responseUserDTO);
		} catch(Exception e) {
			ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
			
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
	
	// 로그인
	@PostMapping("/signin")
	public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO){
		UserEntity user = userService.getByCredentials(
				userDTO.getUserId(), userDTO.getPassword());//, passwordEncoder);
		
		if(user != null) {
			final String token = tokenProvider.create(user);  // 토큰 생성
			final UserDTO responseUserDTO = UserDTO.builder()
					.id(user.getId())    // 로그인 시 사용, 학번
					.userId(user.getUserId())
					.userName(user.getUserName())
					.token(token)
					.build();
			return ResponseEntity.ok().body(responseUserDTO);
		}
		else {
			ResponseDTO responseDTO = ResponseDTO.builder()
					.error("Login failed.")
					.build();
			return ResponseEntity.badRequest().body(responseDTO);
		}
	}
	
}
