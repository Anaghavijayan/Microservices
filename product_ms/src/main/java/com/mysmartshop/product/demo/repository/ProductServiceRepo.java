package com.mysmartshop.product.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysmartshop.product.demo.model.Product;


public interface ProductServiceRepo extends JpaRepository<Product,String>  {

}
