package com.mysmartshop.product.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mysmartshop.product.demo.model.Product;
import com.mysmartshop.product.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;                                                  
	
//	@GetMapping
//	public String greet() {
//		return "Message from Product Service";
//	}
	
    @GetMapping
	 public List<Product> getAvailableProducts(){
	      return productService.getAvailableProducts();
	    }
	@PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @GetMapping("/{id}")
    public Product getProductDetails(@PathVariable String id) {
        return productService.getProductDetails(id);
    }
    @DeleteMapping("/{productId}")
    public void removeProduct(@PathVariable String productId) {
    	productService.removeProduct(productId);
    }
	
//	@GetMapping("/cart")
//	public String fetchproductservicemeassage() {
//		String msg=restClient.getForObject("http://localhost:8200/cart", String.class);
//				return "message recieved from cart services:"+msg;
//	}


}
