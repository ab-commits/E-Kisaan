package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ISupplierRepository;
import com.app.pojos.Supplier;

@Service
@Transactional
public class SupplierServiceImple implements ISupplierService {
	@Autowired
	private ISupplierRepository supRepo;

	@Override
	public Supplier getSupplierDetails(Integer id) {
		return supRepo.findById(id).orElseThrow(() -> new RuntimeException("No Supplier Record Found ...!"));
	}

	@Override
	public String addSupplierDetails(Supplier s) {
		supRepo.save(s);
		System.out.println("hello");
		System.out.println(s);
		return "Supplier addedd successfully ...!";
	}

	@Override
	public Supplier updateSupplierDetails(Supplier sup) {
		return supRepo.save(sup);
	}

	@Override
	public Supplier getSupplierByEmailANdPassword(String email, String password) {
		return supRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<Supplier> findAllSupplier() {
		return supRepo.findAll();
	}

	@Override
	public Supplier findSupplierById(Integer id) {
		return supRepo.findById(id).orElseThrow(() -> new RuntimeException("No Record found"));
	}
}
