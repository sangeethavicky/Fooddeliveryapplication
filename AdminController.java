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
@RequestMapping("/api/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	@Autowired
	private ItemService itemService;

	
	// admin register
	@PostMapping("/register") 
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
		System.out.println("admin register " + admin);
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
	}

	// admin login
	@PostMapping("/login")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.loginAdmin(admin), HttpStatus.OK);

	}
	
	//get all admin details
		@GetMapping
		public List<Admin> getAllAdmins(){
			return adminService.getAllAdmins();
		}
		//get admin by id
		@GetMapping("/{adminId}")
		public ResponseEntity<Admin> getAdminById(@PathVariable("adminId") int adminId){
			
			return new ResponseEntity<Admin>(adminService.getAdminById(adminId),HttpStatus.OK);
		}
		
		//updating admin details
		@PutMapping("{adminId}")
		public ResponseEntity<Admin> updateAdmin(@PathVariable("adminId") int adminId, @RequestBody Admin admin) {
			return new ResponseEntity<Admin>(adminService.updateAdmin(admin,adminId),HttpStatus.OK);
		}
		//delete by id
		@DeleteMapping("{adminId}")
		public ResponseEntity<Boolean> deleteAdmin(@PathVariable("adminId") int adminId){
			adminService.deleteAdmin(adminId);
			boolean flag = true;
			return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
			
		}
		
		

		
		@PostMapping("item/register") 
		public ResponseEntity<Item> saveItem(@Valid @RequestBody Item item) {
			System.out.println("item register " + item);
			return new ResponseEntity<Item>(itemService.saveItem(item), HttpStatus.CREATED);
		}

		

}
