package com.mysmartshop.cart.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Cart{
//	@Id
//	@GeneratedValue
	private int cartId;
    private String productId;
    private int quantity;
    private float totalPrice;
   
}
