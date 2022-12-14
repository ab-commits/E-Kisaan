package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_records")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderRecords extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "cust_id",nullable=false)
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "product_id",nullable=false)
	private Product product;
	
	@Column(length = 10,nullable=false)
	private int quantity;
}
