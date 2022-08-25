package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.pojos.Supplier;
import com.app.service.ISupplierService;

@RestController
@RequestMapping("/api/ekisan/supplier")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplierController {
	@Autowired
	private ISupplierService supService;
	
	@PostMapping("/login")
	public ResponseEntity<?> getSupplier(@RequestBody @Valid UserDTO udto) {
		return new ResponseEntity<>(supService.getSupplierByEmailANdPassword(udto.getEmail(), udto.getPassword()),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addSupplier(@RequestBody @Valid Supplier s) {
		return new ResponseEntity<>(supService.addSupplierDetails(s),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateSupplierDetails(@RequestBody @Valid Supplier s) {
		return new ResponseEntity<>(supService.updateSupplierDetails(s),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> getSuppliers() {
		return new ResponseEntity<>(supService.findAllSupplier(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSupplier(@PathVariable int id) {
		return new ResponseEntity<>(supService.findSupplierById(id), HttpStatus.OK);
	}
}
