package com.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductUpdateDTO implements Serializable {
	private int id;
	private String name;
	private int quantity;
	private double price;
	private String description;
	
}
