package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class HateCategoryEntity {   // 알레르기, 비선호식품 카테고리
	private int categoryId;   		// 카테고리 id
	private String hateCategory;  	// 카테고리: 계란, 우유, 땅콩, 해산물, 과일, 육류
}
