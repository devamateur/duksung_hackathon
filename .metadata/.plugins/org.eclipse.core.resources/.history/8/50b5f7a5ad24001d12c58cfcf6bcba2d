package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="orders")
public class OrderEntity {   // 주문 엔터티
	@Id
	@GeneratedValue(generator="system-uuid")	
	@GenericGenerator(name="system-uuid", strategy="uuid")
	private String orderId;   // 이 객체의 id
	//private String orderNum;   // 주문번호

	private String userId;
    //@JoinColumn(name = "id", referencedColumnName = "id") 
	//private String id;    // 이 객체를 생성한 유저의 id, fk로 참조
	private String foodId;  // 유저가 주문한 음식 이름
	private LocalDateTime orderDate;      // 주문 날짜 및 시간 
	
	private boolean orderFull;  // 주문번호가 꽉 찼는지 체크(수용인원을 넘어섰는지)
	private int waitNum;  // 대기번호: 주문번호가 꽉차면(isFull이 true) 증가함, 다른 유저가 음식을 다 먹으면(자리가 생기면) 감소
}
