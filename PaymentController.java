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
import com.example.demo.model.Payment;
import com.example.demo.service.AdminService;
import com.example.demo.service.PaymentService;


@RestController
@RequestMapping("/api/payment")
public class PaymentController 
{
	@Autowired
	private PaymentService paymentService;
	
	// payment register
		@PostMapping("/register/{orderId}") 
		public ResponseEntity<Payment> savePayment(@Valid @RequestBody Payment payment,@PathVariable("orderId") int orderId) {
			System.out.println("payment register " + payment);
			return new ResponseEntity<Payment>(paymentService.savePayment(payment,orderId), HttpStatus.CREATED);
		}

		//get all payment details
				@GetMapping
				public List<Payment> getAllPayments(){
					return paymentService.getAllPayments();
				}
				//get payment by id
				@GetMapping("/{paymentId}")
				public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") int paymentId){
					
					return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId),HttpStatus.OK);
				}
				
				
				

}
