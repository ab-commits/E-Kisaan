package com.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class OrderDto implements Serializable {
	private int custId;
	private int prodId;
	private double totalCartBill;
	private String tranType;
	private String buyDate;
	
	

}
