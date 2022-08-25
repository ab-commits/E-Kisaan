package com.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.ICategoryRepository;
import com.app.dao.IProductRepository;
import com.app.dto.ProductDTO;
import com.app.dto.ProductUpdateDTO;
import com.app.pojos.Category;
import com.app.pojos.Product;

@Service
@Transactional
public class ProductServiceImple implements IProductService {
	@Value("${file.upload.location}")
	private String location;
	
	@Autowired
	private IProductRepository proRepo;
	
	@Autowired
	private ICategoryRepository catRepo;

	@Override
	public Product addProductDetails(ProductDTO pdto, MultipartFile imageFile) throws IOException {
		imageFile.transferTo(new File(location, imageFile.getOriginalFilename()));
		
		Category category = catRepo.findById(pdto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category Id not valid ...!"));
		//in case valid properties copy properties from dto to entity
		Product product = new Product();
		BeanUtils.copyProperties(pdto, product);
		product.setCategory(category);
		product.setImageName(imageFile.getOriginalFilename());
		return proRepo.save(product);
	}

	@Override
	public String removeProduct(int id) {
		proRepo.deleteByProdId(id);
		return "Product with id " + id + " deleted successfully ...!";
	}

	
	@Override
	public Product updateProductStatus(int id) {
		Product p = proRepo.findById(id).orElseThrow(() -> new RuntimeException("Invalid Id"));
		p.setStatus("Approved");
		return proRepo.save(p);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return proRepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return proRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found ...!"));
	}

	@Override
	public Product updateProductDetails (ProductUpdateDTO pdto) {
		
		Product product = proRepo.findById(pdto.getId()).orElseThrow(() -> new RuntimeException("Prod Id not valid ...!"));
		product.setName(pdto.getName());
		product.setPrice(pdto.getPrice());
		product.setDescription(pdto.getDescription());
		product.setQuantity(pdto.getQuantity());
		return proRepo.save(product);
	}

	@Override
	public List<Product> getProductsByCategory(int catId) {
		return proRepo.findByCategoryId(catId);
	}
	
	
	
}
