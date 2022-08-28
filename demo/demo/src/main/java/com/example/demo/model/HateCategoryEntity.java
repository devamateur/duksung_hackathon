package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class HateCategoryEntity {   // �˷�����, ��ȣ��ǰ ī�װ���
	private int categoryId;   		// ī�װ��� id
	private String hateCategory;  	// ī�װ���: ���, ����, ����, �ػ깰, ����, ����
}