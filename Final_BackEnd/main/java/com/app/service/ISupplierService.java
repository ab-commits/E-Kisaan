package com.app.service;

import java.util.List;

import com.app.pojos.Supplier;

public interface ISupplierService {
	public Supplier getSupplierDetails(Integer id);
	public Supplier getSupplierByEmailANdPassword(String email, String password);
	public String addSupplierDetails(Supplier s);
	public Supplier updateSupplierDetails(Supplier sup);
	public List<Supplier> findAllSupplier();
	public Supplier findSupplierById(Integer id);
}
