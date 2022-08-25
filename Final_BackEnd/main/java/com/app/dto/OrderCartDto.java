package com.app.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderCartDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3315177484269580057L;
	private int custId;
	private String buyDate;
	private String tranType;
	private double totalCartBill;

}
