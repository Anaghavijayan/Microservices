package com.mysmartshop.cart.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mysmartshop.cart.demo.Repository.CartServiceRepo;
import com.mysmartshop.cart.demo.dto.Product;
import com.mysmartshop.cart.demo.model.Cart;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CartServiceImpl implements  CartService{
	
	@Autowired
	private CartServiceRepo repo;
	
	@Autowired
	RestTemplate productServiceClient;


	@Override
	public List<Cart> addToCart(String productId) {
		Optional<Cart>checkItem=repo.findByProductId(productId);
		if(!checkItem.isPresent()) {
			Cart item = new Cart();
			item.setProductId(productId);
			item.setQuantity(1);
			item.setTotalPrice(getPrice(productId));
			repo.save(item);
		}
		else {
			Cart item = checkItem.get();
			updateQuantity(productId, item.getQuantity()+1);
		}
		
		return getAllItems();
	}


	@Override
    public List<Cart> removeFromCart(String productId) {
		
		Optional<Cart> checkItem = repo.findByProductId(productId);
		if(checkItem.isPresent()) {
			Cart item = checkItem.get();
			repo.delete(item);
		}
		
		
		return getAllItems();
	}


	@Override
    public List<Cart> updateQuantity(String productId, int quantity) {
		
		Optional<Cart> checkItem = repo.findByProductId(productId);
		
		if(checkItem.isPresent()) {
			Cart item = checkItem.get();
			item.setQuantity(quantity);
			item.setTotalPrice(item.getTotalPrice()*quantity);
			repo.save(item);
		}
		
		return getAllItems();
		
	}
	
	@Override
	public List<Cart> getAllItems(){
		return repo.findAll();
	}

    

	@Override
	public float calculateTotalCost() {
		return repo.getTotalCartValue();
		
	}
       
	 @CircuitBreaker(fallbackMethod = "fetchPriceFallback", name="cb-product")
       private float getPrice(String productId) {
		
		Product product = productServiceClient.getForObject("http://localhost:8100/api/product/"+productId, Product.class);
		
		if(product != null)
			return product.getPrice();
		return 0;
	}
       private float fetchPriceFallback(String productId, Throwable t) {
    	   Product product= new Product(productId,"Dummy Product",0,"A Dummy Product");
    	   System.err.println(t.getMessage());
    	   System.out.println("Response from Fallback");
    	   System.out.println(product);
    	   return product.getPrice();
       }
	


}
