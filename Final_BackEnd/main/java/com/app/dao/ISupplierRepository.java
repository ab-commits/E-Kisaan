package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Supplier;

public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
	Supplier findByEmailAndPassword(String email, String password);
}
