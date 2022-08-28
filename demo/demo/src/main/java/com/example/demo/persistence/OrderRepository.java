package com.example.demo.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
	public static final JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	List<OrderEntity> findByUserId(String userId);   // userid로 주문내역 조회
	
	public static List<Integer> getOrderCount(){
		List<Integer> orderCount = new ArrayList<>();
		orderCount.addAll(jdbcTemplate.queryForList("select count(*) from orders;", Integer.class));
		return orderCount;
	}
}
