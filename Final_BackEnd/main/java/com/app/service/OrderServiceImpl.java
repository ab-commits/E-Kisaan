package com.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartRepository;
import com.app.dao.IOrderRecordRepository;
import com.app.dao.IOrderRepository;
import com.app.dao.IProductRepository;
import com.app.dao.IUserRepository;
import com.app.dto.OrderCartDto;
import com.app.dto.OrderDto;
import com.app.dto.OrderResponseDTO;
import com.app.pojos.Cart;
import com.app.pojos.Order;
import com.app.pojos.OrderRecords;
import com.app.pojos.OrderStatus;
import com.app.pojos.Product;
import com.app.pojos.TransactionType;
import com.app.pojos.User;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepo;

	@Autowired
	private IOrderRecordRepository orderRecordRepo;

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IProductRepository prodRepo;

	@Autowired
	private ICartRepository cartRepo;
/*
	@Override
	public List<OrderResponseDTO> getAllOrders(int customerId) {
		User customer = userRepo.findById(customerId).orElseThrow(() -> new RuntimeException("InvalidCustomer Id"));
		List<Order> orders = orderRepo.findByUser(customer);
		
		
		List<OrderRecords> orderRecords = orderRecordRepo.findByCustomer(customer);
		

		List<OrderResponseDTO> newList = new ArrayList<>();

		orders.forEach(order -> {
			orderRecords.forEach(or -> {
				newList.add(new OrderResponseDTO(or.getProduct().getName(), order.getOrderDate(),
						or.getQuantity(),

						or.getProduct().getPrice(),

						or.getProduct().getImageName(),

						order.getOrderStatus()));
			});
			
			
		});

		 return newList;

	}
	
	*/
	
	
	
	@Override
	public List<OrderResponseDTO> getAllOrders(int customerId) {
		User customer = userRepo.findById(customerId).orElseThrow(() -> new RuntimeException("InvalidCustomer Id"));
		List<Order> orders = orderRepo.findByUser(customer);

		List<OrderResponseDTO> newList = new ArrayList<>();

		orders.forEach(order -> {
			
			List<OrderRecords> orderRecords = orderRecordRepo.findByOrder(order);
			
			orderRecords.forEach(or -> {
				
				newList.add(new OrderResponseDTO(
						or.getProduct().getName(), 
						order.getOrderDate(),
						or.getQuantity(),
						or.getProduct().getPrice(),
						or.getProduct().getImageName(),
						order.getOrderStatus()));
			});
			
		});
		 return newList;
	}
	
	
	
	
	/*

	@Override
	public String buyAProduct(OrderDto order) {
		User customer = userRepo.findById(order.getCustId())
				.orElseThrow(() -> new RuntimeException("InvalidCustomer Id"));

		Order o = new Order(LocalDate.parse(order.getBuyDate()), OrderStatus.valueOf("PLACED"), order.getBillAmount(),
				TransactionType.valueOf(order.getTransactionType()), customer);
		Order o1 = orderRepo.save(o);
		Product p = prodRepo.findById(order.getProdId()).orElseThrow(() -> new RuntimeException("invalid Product Id"));
		p.setQuantity(p.getQuantity() - 1);
		OrderRecords or = new OrderRecords(o1, customer, p, order.getQuantity());

		orderRecordRepo.save(or);
		return "Order Placed";
	}*/

	@Override
	public String addToOrder(OrderCartDto order) throws ParseException {
		User customer = userRepo.findById(order.getCustId())
				.orElseThrow(() -> new RuntimeException("InvalidCustomer Id"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Order o = new Order(LocalDate.parse(sdf.format(sdf.parse(order.getBuyDate()))), OrderStatus.valueOf("PLACED"),
				order.getTotalCartBill(), TransactionType.valueOf(order.getTranType()), customer);
		Order o1 = orderRepo.save(o);
		List<Cart> cartList = cartRepo.findByCustomer(customer);
		cartList.forEach((cart) -> {
			Product p = prodRepo.findById(cart.getProduct().getId())
					.orElseThrow(() -> new RuntimeException("invalid Product Id"));
			p.setQuantity(p.getQuantity() - cart.getQuantity());
			prodRepo.save(p);
			OrderRecords or = new OrderRecords(o1, customer, p, cart.getQuantity());
			orderRecordRepo.save(or);
		});

		return "order Cart Placed";
	}






	@Override
	public String addToOrder2(OrderDto order) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User customer = userRepo.findById(order.getCustId())
				.orElseThrow(() -> new RuntimeException("InvalidCustomer Id"));
		Order o = new Order(LocalDate.parse(sdf.format(sdf.parse(order.getBuyDate()))), OrderStatus.valueOf("PLACED"),
				order.getTotalCartBill(), TransactionType.valueOf(order.getTranType()), customer);
		Order o1 = orderRepo.save(o);
		
		Product p = prodRepo.findById(order.getProdId())
				.orElseThrow(() -> new RuntimeException("invalid Product Id"));
		p.setQuantity(p.getQuantity() - 1);
		prodRepo.save(p);
		OrderRecords or = new OrderRecords(o1, customer, p, 1);
		orderRecordRepo.save(or);
		
		return "order Placed";
	}

}
