package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ProductDTO;
import com.app.dto.ProductUpdateDTO;
import com.app.pojos.Product;

public interface IProductService {
	public Product addProductDetails(ProductDTO pdto, MultipartFile imageFile) throws IOException;
	public String removeProduct(int id);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public Product updateProductDetails(ProductUpdateDTO pdto);
	public Product updateProductStatus(int id);
	public List<Product> getProductsByCategory(int catId);
	
}
