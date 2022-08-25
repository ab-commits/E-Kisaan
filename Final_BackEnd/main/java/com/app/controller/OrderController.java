package com.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrderCartDto;
import com.app.dto.OrderDto;
import com.app.service.IOrderService;

@RestController
@RequestMapping("/api/ekisan/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	@Autowired
	private IOrderService orderService;

	@GetMapping("/details/{id}")
	public ResponseEntity<?> getAllOrders(@PathVariable int id) {
		return new ResponseEntity<>(orderService.getAllOrders(id), HttpStatus.OK);
	}
//
//	@PostMapping("/customer/buy")
//	public ResponseEntity<?> buyAProduct(@RequestBody OrderDto orderDto) {
//		return new ResponseEntity<>(orderService.buyAProduct(orderDto), HttpStatus.OK);
//	}

	@PostMapping("/add")
	public ResponseEntity<?> addToOrderList(@RequestBody OrderCartDto order) throws ParseException {
		return new ResponseEntity<>(orderService.addToOrder(order), HttpStatus.OK);
	}
	
	@PostMapping("/buy")
	public ResponseEntity<?> addToOrderList2(@RequestBody OrderDto order) throws ParseException {
		return new ResponseEntity<>(orderService.addToOrder2(order), HttpStatus.OK);
	}
}
