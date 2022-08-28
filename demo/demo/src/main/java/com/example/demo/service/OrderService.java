package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderEntity;
import com.example.demo.persistence.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	// �ֹ�
	public List<OrderEntity> create(final OrderEntity entity){
		// entity validation
		validate(entity); 
		
		orderRepository.save(entity);
		
		/*if(OrderRepository.getOrderCount().get(0) != null && OrderRepository.getOrderCount().get(0) > 2) {
			entity.setOrderFull(true);
			entity.setWaitNum(entity.getWaitNum() + 1);
			log.info("!����Ƽ ����ȣ!: {}. ", entity.getWaitNum());
		}*/
		
		log.info("Entity Id: {} is saved.", entity.getOrderId());  // order id ��������
		//return orderRepository.findByUserId(entity.getUserId());   // repository���� userid�� �ֹ� ��������
		return orderRepository.findByUserId(entity.getUserId());
	}
	
	// �ֹ� ����
	public List<OrderEntity> retrieve(final String userId){
		return orderRepository.findByUserId(userId);
	}
	
	
	private void validate(final OrderEntity entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null");
		}
		if(entity.getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Unknown user.");
		}
	}
}