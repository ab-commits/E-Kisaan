package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
	@Query("select p from Product p where p.category.id = :id")
	public List<Product> findByCategoryId(@Param("id") Integer id);
	
	//or
	//public List<Product> findByCategory_id(int id);
	
	@Modifying
	@Query("delete from Product p where p.id =:id")
	public void deleteByProdId(@Param("id") int id);
	
}
