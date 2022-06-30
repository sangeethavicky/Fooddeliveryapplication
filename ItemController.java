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
import com.example.demo.service.AdminService;
import com.example.demo.service.ItemService;


@RestController
@RequestMapping("/api/item")
public class ItemController 
{
	@Autowired
	private ItemService itemService;

	
	@PostMapping("/register") 
	public ResponseEntity<Item> saveItem(@Valid @RequestBody Item item) {
		System.out.println("item register " + item);
		return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);
	}

	
	//get all item details
		@GetMapping
		public List<Item> getAllItems(){
			return itemService.getAllItems();
		}
		//get item by id
		@GetMapping("/{itemId}")
		public ResponseEntity<Item> getItemById(@PathVariable("itemId") int itemId){
			
			return new ResponseEntity<Item>(itemService.getItemById(itemId),HttpStatus.OK);
		}
		
		//updating item details
		@PutMapping("{itemId}")
		public ResponseEntity<Item> updateItem(@PathVariable("itemId") int itemId, @RequestBody Item item) {
			return new ResponseEntity<Item>(itemService.updateItem(item,itemId),HttpStatus.OK);
		}
		//delete by id
		@DeleteMapping("{itemId}")
		public ResponseEntity<String> deleteItem(@PathVariable("itemId") int itemId){
			itemService.deleteItem(itemId);
			String message="Item's got deleted";
			return new ResponseEntity<String>(message, HttpStatus.OK);
			
		}
	

}
