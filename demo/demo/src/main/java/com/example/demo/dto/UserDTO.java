package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	private String token;
	private String id;       // 객체의 아이디
	private String userId;  // 로그인 시 사용하는 아이디
	private String userName;
	private String password;
}
