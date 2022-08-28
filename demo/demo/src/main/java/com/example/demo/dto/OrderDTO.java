package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.model.OrderEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
	private String orderId;   // 이 객체의 id
	//private String orderNum;   // 주문번호
	private String userId;    // 이 객체를 생성한 유저의 id
	private String foodId;  // 유저가 주문한 음식 id
	private LocalDateTime orderDate;      // 주문 날짜 및 시간 

	private boolean orderFull;  // 주문번호가 꽉 찼는지 체크(수용인원을 넘어섰는지)
	private int waitNum;  // 대기번호: 주문번호가 꽉차면(isFull이 true) 증가함, 다른 유저가 음식을 다 먹으면(자리가 생기면) 감소
	
	public OrderDTO(final OrderEntity entity) {
		this.orderId = entity.getOrderId();
		this.userId = entity.getUserId();
		this.foodId = entity.getFoodId();
		this.orderDate = entity.getOrderDate();
		this.orderFull = entity.isOrderFull();
		this.waitNum = entity.getWaitNum();
	}
	
	public static OrderEntity toEntity(final OrderDTO dto) {
		return OrderEntity.builder()
				.orderId(dto.getOrderId())
				.userId(dto.getUserId())
				.foodId(dto.getFoodId())
				.orderDate(dto.getOrderDate())
				.orderFull(dto.isOrderFull())
				.waitNum(dto.getWaitNum())
				.build();
				
	}
}
