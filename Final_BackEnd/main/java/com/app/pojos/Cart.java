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
@Table(name="cart")

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Cart extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(length = 10)
	private int quantity;
	
	public Cart(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString()
	{
		return quantity+" "+super.getId()+" hfhfj";
	}
}


