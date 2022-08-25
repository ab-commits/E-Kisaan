package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartDto;
import com.app.pojos.Cart;
import com.app.service.ICartService;

@RestController
@RequestMapping("/api/ekisan/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

	@Autowired
	private ICartService cartService;

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerCartList(@PathVariable int id) {
		return new ResponseEntity<>(cartService.showFullCart(id), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addProductInCart(@RequestBody CartDto cDto) {
		return new ResponseEntity<>(cartService.addToCart(cDto.getCustomerId(), cDto.getProductId(), new Cart(cDto.getQuantity())), HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> removeFromCart(@PathVariable int id) {
		return new ResponseEntity<>(cartService.removeFromCart(id), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateQuantity(@RequestBody CartDto cDto) {
		return new ResponseEntity<>(cartService.updateQuantity(cDto.getQuantity(),cDto.getCustomerId(), cDto.getProductId()), HttpStatus.OK);
		
	}

	@DeleteMapping("/removeall/{id}")
	public ResponseEntity<?> deleteFullCart(@PathVariable int id) {
		return new ResponseEntity<>(cartService.deleteCartWithCustomerId(id), HttpStatus.OK);
	}

}
