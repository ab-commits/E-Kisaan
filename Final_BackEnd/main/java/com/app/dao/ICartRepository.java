package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Cart;
import com.app.pojos.User;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
	@Modifying
	@Query(value="delete from Cart c where c.customer.id=:customerId and c.product.id=:productId")
	public Cart removeFromCart(@Param("customerId") int customerId,@Param("productId") int productId );
	
//	@Modifying
//	@Query(value="select c from Cart where c.customer.id = :cid")
	public List<Cart> findByCustomer(User u);
	
	@Modifying
	@Query(value="update Cart c set c.quantity=:quantity where c.customer.id=:customerId and c.product.id=:productId")
	public void updateQuantity(@Param("quantity") int quantity,@Param("customerId") int customerId,@Param("productId") int productId);
	
	@Modifying
	@Query(value="delete from Cart c where c.customer.id=:customerId")
	public void deleteFullCart(@Param("customerId") int customerId);
}
