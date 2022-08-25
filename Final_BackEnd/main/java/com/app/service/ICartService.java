package com.app.service;

import java.util.List;

import com.app.pojos.Cart;

public interface ICartService {
	public Cart addToCart(int userId,int prodId, Cart cart);
	public String removeFromCart(int id);
	public List<Cart> showFullCart(Integer custId);
	public String updateQuantity(int quantity,int customerId,int prodId);
	public String deleteCartWithCustomerId(Integer custId);
}
