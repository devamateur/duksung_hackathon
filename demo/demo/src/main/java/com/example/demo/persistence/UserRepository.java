package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	UserEntity findByUserIdAndPassword(String userId, String password);   // id�� password�� ����� ��ȸ
	UserEntity findByUserId(String userId);
	boolean existsByUserId(String userId);
}