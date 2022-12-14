package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HateFoodEntity {
	private int hateFoodId;   // PK
	private int categoryId;     // FK, HateCategory?? ?⺻Ű
	private String hateFoodName;   
}
