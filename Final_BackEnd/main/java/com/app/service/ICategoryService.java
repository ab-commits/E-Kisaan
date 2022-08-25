package com.app.service;

import java.util.List;

import com.app.pojos.Category;

public interface ICategoryService {
	public Category getCategoryById(Integer id);
	public List<Category> getAllCategories();
	public String addCategory(String cat);
	public String deleteCategory(int catId);
}
