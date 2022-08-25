package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Order;
import com.app.pojos.OrderRecords;
import com.app.pojos.User;

public interface IOrderRecordRepository extends JpaRepository<OrderRecords, Integer> {
	List<OrderRecords> findByCustomer(User cust);
	List<OrderRecords> findByOrder(Order o);
}
