package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICategoryRepository;
import com.app.pojos.Category;

@Service
@Transactional
public class CategoryServiceImple implements ICategoryService {
	@Autowired
	private ICategoryRepository catRepo;

	@Override
	public Category getCategoryById(Integer id) {
		return catRepo.findById(id).orElseThrow(() -> new RuntimeException("Category Record Not Found ...!"));
	}

	@Override
	public List<Category> getAllCategories() {
		return catRepo.findAll();
	}

	@Override
	public String addCategory(String name) {
		
		catRepo.save(new Category(name));
		return "Category addedd successfully ...!";
	}

	@Override
	public String deleteCategory(int catId) {
		catRepo.deleteById(catId);
		return "Category  details with id " + catId + " deleted successfully ...!";
	}
}
