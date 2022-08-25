package com.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO implements Serializable {
	private String name;
	private int categoryId;
	private int quantity;
	private double price;
	private String description;
	private String status;
	private String imageName;
}
