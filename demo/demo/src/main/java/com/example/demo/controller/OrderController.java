package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.model.OrderEntity;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<?> createOrder(@AuthenticationPrincipal String userId, @RequestBody OrderDTO dto){
		try {
			//String tempUserId = "temporary";   // �ӽ� ����
			
			OrderEntity entity = OrderDTO.toEntity(dto);
			
			entity.setOrderId(null);   // ���� ��� id�� null
			
			entity.setUserId(userId);      
			
			entity.setOrderDate(LocalDateTime.now());   // ���� �ð� �־��ֱ�
			
			// service�� OrderEntity ����
			List<OrderEntity> entities = orderService.create(entity);
			
			// OrderEntity ����Ʈ�� OrderDTO�� ��ȯ
			List<OrderDTO> dtos = entities.stream().map(OrderDTO::new).collect(Collectors.toList());
			
			ResponseDTO<OrderDTO> response = ResponseDTO.<OrderDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(response);
			
			
		} catch(Exception e) {
			String error = e.getMessage();
			ResponseDTO<OrderDTO> response = ResponseDTO.<OrderDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> retrieveOrderList(@AuthenticationPrincipal String userId){
		// ����� id�� �ֹ������� ������
		List<OrderEntity> entities = orderService.retrieve(userId);
		
		// entities�� dtos��
		List<OrderDTO> dtos = entities.stream().map(OrderDTO::new).collect(Collectors.toList());
		
		// ResponseDTO �ʱ�ȭ
		ResponseDTO<OrderDTO> response = ResponseDTO.<OrderDTO>builder().data(dtos).build();
		
		return ResponseEntity.ok().body(response);
		
	}
	
}