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
	private String orderId;   // �� ��ü�� id
	//private String orderNum;   // �ֹ���ȣ
	private String userId;    // �� ��ü�� ������ ������ id
	private String foodId;  // ������ �ֹ��� ���� id
	private LocalDateTime orderDate;      // �ֹ� ��¥ �� �ð� 

	private boolean orderFull;  // �ֹ���ȣ�� �� á���� üũ(�����ο��� �Ѿ����)
	private int waitNum;  // ����ȣ: �ֹ���ȣ�� ������(isFull�� true) ������, �ٸ� ������ ������ �� ������(�ڸ��� �����) ����
	
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
