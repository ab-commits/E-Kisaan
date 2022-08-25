package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "orders")
public class Order extends BaseEntity {

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@NotNull
	private double billAmount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transType;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
}
