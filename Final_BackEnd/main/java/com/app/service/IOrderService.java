package com.app.service;

import java.text.ParseException;
import java.util.List;

import com.app.dto.OrderCartDto;
import com.app.dto.OrderDto;
import com.app.dto.OrderResponseDTO;

public interface IOrderService {
	List<OrderResponseDTO> getAllOrders(int customerId);

	//String buyAProduct(OrderDto order);

	String addToOrder(OrderCartDto oCartDto) throws ParseException;

	String addToOrder2(OrderDto order) throws ParseException;

}
