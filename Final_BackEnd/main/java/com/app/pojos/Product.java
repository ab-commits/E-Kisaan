package com.app.pojos;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product extends BaseEntity {
	@NotBlank
	@Column(length = 30, unique = true)
	private String name;
	@NotNull
	@Min(value = 0)
	private double price;
	@NotNull
	@Min(value = 0)
	private int quantity;
	@NotBlank
	@Column(length = 255, name = "image_name")
	@JsonProperty("image")
	private String imageName;
	@NotBlank
	@Column(length = 50)
	private String description;
	@Column(length = 10)
	private String status;
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@JsonBackReference
	private Category category;	
}
