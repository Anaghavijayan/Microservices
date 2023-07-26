package com.mysmartshop.cart.demo.dto;

import java.util.List;

import com.mysmartshop.cart.demo.model.Cart;

import lombok.Data;

@Data
public class CartDetails {
	
	private List<Cart> itemsList;
	private float totalCartValue;


}
