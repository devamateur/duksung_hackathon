package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user", uniqueConstraints = {@UniqueConstraint(columnNames="user_id")})
public class UserEntity {
	@Id
	@GeneratedValue(generator="system-uuid")	
	@GenericGenerator(name="system-uuid", strategy="uuid")
    //@Column(name="user_id", nullable = false, unique = true)
	private String id;
		
	@Column(name="user_id", nullable = false)
	private String userId;   // 로그인 아이디
	
	@Column(name="user_name", nullable = false)
	private String userName;
	
	@Column(name="password", nullable = false)
	private String password;
}
