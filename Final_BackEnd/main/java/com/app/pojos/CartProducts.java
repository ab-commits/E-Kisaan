package com.app.pojos;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartProducts {
	private Product product;

}
