package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	@JsonManagedReference
	@JsonProperty("name")
	private CategoryType categoryType;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER )
	private List<Product> products = new ArrayList<>();
	
	public Category(String name) {
		categoryType = CategoryType.valueOf(name.toUpperCase());
		products = new ArrayList<>();
	}
	
	public void addProduct(Product p) {
		products.add(p);
		p.setCategory(this);
	}
	
	public void removeProduct(Product p) {
		products.remove(p);
		p.setCategory(null);
	}

}
