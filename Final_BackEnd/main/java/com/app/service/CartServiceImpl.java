package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartRepository;
import com.app.dao.IProductRepository;
import com.app.dao.IUserRepository;
import com.app.pojos.Cart;
import com.app.pojos.Product;
import com.app.pojos.User;

@Service
@Transactional
public class CartServiceImpl implements ICartService {
	@Autowired
	private ICartRepository cartRepo;
	@Autowired
	private IProductRepository prodRepo;
	@Autowired
	private IUserRepository userRepo;

	@Override
	public Cart addToCart(int userId, int prodId, Cart cart) {
		User customer = userRepo.getById(userId);
		Product prod = prodRepo.getById(prodId);
		cart.setCustomer(customer);
		cart.setProduct(prod);
		return cartRepo.save(cart);
	}

	@Override
	public String removeFromCart(int id) {
		cartRepo.deleteById(id);
		return "Prod successfuly removed";
	}

	@Override
	public List<Cart> showFullCart(Integer custId) {
		User user = userRepo.findById(custId).orElseThrow(() -> new RuntimeException("No data found"));
		return cartRepo.findByCustomer(user);
	}

	@Override
	public String updateQuantity(int quantity, int customerId, int prodId) {
		cartRepo.updateQuantity(quantity, customerId, prodId);
		return "cart successfully updated";

	}
	
	
	@Override
	public String deleteCartWithCustomerId(Integer custId) {
		
		cartRepo.deleteFullCart(custId);
		return "cart succesffuly deleted";
	}

}
