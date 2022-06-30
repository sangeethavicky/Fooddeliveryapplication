package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.service.AdminService;
import com.example.demo.service.ItemService;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController 
{
	@Autowired
	private OrderService orderService;

	
	// order register
	@PostMapping("/register/{cartId}") 
	public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order order,@PathVariable("cartId") int cartId) {
		
		return new ResponseEntity<Order>(orderService.saveOrder(order,cartId), HttpStatus.CREATED);
	}

	
	//get all order details
		@GetMapping
		public List<Order> getAllOrders(){
			return orderService.getAllOrders();
		}
		//get order by id
		@GetMapping("/{orderId}")
		public ResponseEntity<Order> getOrderById(@PathVariable("orderId") int orderId){
			
			return new ResponseEntity<Order>(orderService.getOrderById(orderId),HttpStatus.OK);
		}
		
		//delete by id
		@DeleteMapping("{orderId}")
		public ResponseEntity<Boolean> deleteOrder(@PathVariable("orderId") int orderId){
			orderService.deleteOrder(orderId);
			boolean flag = true;
			return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
			
		}	
		

}
