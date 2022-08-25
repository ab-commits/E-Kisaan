package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ICategoryService;

@RestController
@RequestMapping("/api/ekisan/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
	@Autowired
	private ICategoryService catService;

	@GetMapping
	public ResponseEntity<?> getAllCategories() {
		return new ResponseEntity<>(catService.getAllCategories(), HttpStatus.OK);
	}

	@PostMapping("/add/{name}")
	public ResponseEntity<?> addcategory(@PathVariable String name) {
		return ResponseEntity.status(HttpStatus.CREATED).body(catService.addCategory(name));
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable int id) {
		return new ResponseEntity<>(catService.deleteCategory(id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id) {
		return new ResponseEntity<>(catService.getCategoryById(id), HttpStatus.OK);
	}

}
