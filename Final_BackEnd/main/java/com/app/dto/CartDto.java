package com.app.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartDto {
	@JsonProperty("custid")
 private int customerId;
	@JsonProperty("pid")	
 private int productId;
 private int quantity;
 
 
}
