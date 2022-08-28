package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="food")
public class FoodEntity {
	@Id
	//@GeneratedValue(generator="system-uuid")	
	//@GenericGenerator(name="system-uuid", strategy="uuid")
	private String foodId;   // ���� id
	private String foodCategory;
	private String foodName;   // ���� �̸�
	private String foodPrice;      // ����
}