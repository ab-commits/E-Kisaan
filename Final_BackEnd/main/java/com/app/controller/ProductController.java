package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ProductDTO;
import com.app.dto.ProductUpdateDTO;
import com.app.pojos.Product;
import com.app.service.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/ekisan/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	private IProductService proService;

	@Autowired
	private ObjectMapper mapper;

	@Value("${file.upload.location}")
	private String location;

	@PostMapping("/add")
	public Product addProduct(@RequestParam String productDetails, @RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println(productDetails);
		ProductDTO details = mapper.readValue(productDetails, ProductDTO.class);
		return proService.addProductDetails(details, imageFile);
	}

	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		return new ResponseEntity<>(proService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getAllProductsByCategory(@PathVariable int id) {
		return new ResponseEntity<>(proService.getProductsByCategory(id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable int id) {
		return new ResponseEntity<>(proService.getProductById(id), HttpStatus.OK);
	}
//
	@PutMapping("/update")
	public ResponseEntity<?> updateProductDetails(@RequestBody ProductUpdateDTO p) {
		return new ResponseEntity<>(proService.updateProductDetails(p), HttpStatus.OK);
	}
	
	@PutMapping("/updatestatus/{id}")
	public ResponseEntity<?> updateProductStatus(@PathVariable int id) {
		return new ResponseEntity<>(proService.updateProductStatus(id), HttpStatus.OK);
	}
//	

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		return new ResponseEntity<>(proService.removeProduct(id), HttpStatus.OK);
	}
	

	
	
}
