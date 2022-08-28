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
public class OrderEntity {   // �ֹ� ����Ƽ
	@Id
	@GeneratedValue(generator="system-uuid")	
	@GenericGenerator(name="system-uuid", strategy="uuid")
	private String orderId;   // �� ��ü�� id
	//private String orderNum;   // �ֹ���ȣ

	private String userId;
    //@JoinColumn(name = "id", referencedColumnName = "id") 
	//private String id;    // �� ��ü�� ������ ������ id, fk�� ����
	private String foodId;  // ������ �ֹ��� ���� �̸�
	private LocalDateTime orderDate;      // �ֹ� ��¥ �� �ð� 
	
	private boolean orderFull;  // �ֹ���ȣ�� �� á���� üũ(�����ο��� �Ѿ����)
	private int waitNum;  // ����ȣ: �ֹ���ȣ�� ������(isFull�� true) ������, �ٸ� ������ ������ �� ������(�ڸ��� �����) ����
}
