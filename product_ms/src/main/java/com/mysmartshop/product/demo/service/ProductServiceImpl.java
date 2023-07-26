package com.mysmartshop.product.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysmartshop.product.demo.model.Product;
import com.mysmartshop.product.demo.repository.ProductServiceRepo;

 

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductServiceRepo repo;

 

    @Override
    public List<Product> getAvailableProducts() {
        return repo.findAll();
    }

 

    @Override
    public Product getProductDetails(String productId) {
        return repo.findById(productId).get();
    }


    @Override
    public Product addProduct(Product product) {
        repo.save(product);
        return product;

    }

    @Override
    public void removeProduct(String productId) {
        repo.deleteById(productId);
    }

}
