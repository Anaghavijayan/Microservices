package com.mysmartshop.cart.demo.Service;

import java.util.List;

import com.mysmartshop.cart.demo.model.Cart;

public interface CartService {
	
	  public List <Cart> addToCart(String productId);
	
	  public List <Cart> removeFromCart(String productId);
	  
	  public List <Cart> updateQuantity(String productId, int quantity);
	  
	  public float calculateTotalCost();
	  
	  public List<Cart> getAllItems();

}
