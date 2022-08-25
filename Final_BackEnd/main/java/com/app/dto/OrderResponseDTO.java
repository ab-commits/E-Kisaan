package com.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.app.pojos.OrderStatus;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class OrderResponseDTO implements Serializable {
	private String name;
	private LocalDate date;
	private int quantity;
	private double price;
	private String image;
	private OrderStatus status;
	public OrderResponseDTO(String name, LocalDate date, int quantity, double price, String image, OrderStatus status) {
		super();
		this.name = name;
		this.date = date;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
		this.status = status;
	}
	
	
}
