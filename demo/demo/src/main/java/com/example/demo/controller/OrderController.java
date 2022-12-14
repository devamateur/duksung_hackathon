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
			//String tempUserId = "temporary";   // 임시 유저
			
			OrderEntity entity = OrderDTO.toEntity(dto);
			
			entity.setOrderId(null);   // 생성 당시 id는 null
			
			entity.setUserId(userId);      
			
			entity.setOrderDate(LocalDateTime.now());   // 현재 시간 넣어주기
			
			// service로 OrderEntity 생성
			List<OrderEntity> entities = orderService.create(entity);
			
			// OrderEntity 리스트를 OrderDTO로 변환
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
		// 사용자 id로 주문내역을 가져옴
		List<OrderEntity> entities = orderService.retrieve(userId);
		
		// entities를 dtos로
		List<OrderDTO> dtos = entities.stream().map(OrderDTO::new).collect(Collectors.toList());
		
		// ResponseDTO 초기화
		ResponseDTO<OrderDTO> response = ResponseDTO.<OrderDTO>builder().data(dtos).build();
		
		return ResponseEntity.ok().body(response);
		
	}
	
}
