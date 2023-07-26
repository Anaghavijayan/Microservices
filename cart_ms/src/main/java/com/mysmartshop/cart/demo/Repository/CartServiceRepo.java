package com.mysmartshop.cart.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mysmartshop.cart.demo.model.Cart;

public interface CartServiceRepo extends JpaRepository<Cart,Integer> {

	public Optional<Cart>findByProductId(String productId);
	
	@Query(value = "select sum(total_price) from cart",nativeQuery = true)
	public float getTotalCartValue();

}
