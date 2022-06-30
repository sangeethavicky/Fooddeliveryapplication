package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Cart;
import com.example.demo.service.AdminService;
import com.example.demo.service.CartService;
@RestController
@RequestMapping("/api/cart")
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	// cart register
		@PostMapping("/register/{itemId}/{customerId}") 
		public ResponseEntity<Cart> saveCart(@Valid @RequestBody Cart cart,@PathVariable("itemId") int itemId,@PathVariable("customerId") long customerId ) {
			
			return new ResponseEntity<Cart>(cartService.saveCart(cart,itemId,customerId), HttpStatus.CREATED);
		}

		
		
		//get all cart details
			@GetMapping
			public List<Cart> getAllCarts(){
				return cartService.getAllCarts();
			}
			//get cart by id
			@GetMapping("/{cartId}")
			public ResponseEntity<Cart> getCartById(@PathVariable("cartId") int cartId){
				
				return new ResponseEntity<Cart>(cartService.getCartById(cartId),HttpStatus.OK);
			}
			
			
			//delete by id
			@DeleteMapping("{cartId}")
			public ResponseEntity<Boolean> deleteCart(@PathVariable("cartId") int cartId){
				cartService.deleteCart(cartId);
				boolean flag = true;
				return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
				
			}

}
