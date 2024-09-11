package com.Zahiri.CarCompany.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Zahiri.CarCompany.Entity.Customer;
import com.Zahiri.CarCompany.Service.CustomerService;

@RestController
@RequestMapping("/api/customerApi")
@CrossOrigin(origins="*" , allowedHeaders = "*") 
public class CarCompanyCustomerController {
	
	@Autowired
	CustomerService customerService; 
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello World from Customer";
	}
	
	
	// seeing all Customers 
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(){
		return new ResponseEntity<>(customerService.findAllCustomer(),HttpStatus.OK);
	}
	
	// Saving a Customer
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
	// finding customer by ID
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id ){
		return new ResponseEntity<>(customerService.findCustomerById(id) , HttpStatus.OK);
	}
	
	
	// finding customer by Last Name 
	@GetMapping("/customers/{name}")
	public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable String name){
		return new ResponseEntity<>(customerService.findCustomerByLastName(name),HttpStatus.OK);
	}
	
	// updating customer by ID
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id , @RequestBody Customer customer ){
		return new ResponseEntity<>(customerService.updateCustomer(id, customer),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable int id){
		return new ResponseEntity<>(customerService.deleteCustomerById(id),HttpStatus.OK);
	}
	
	
	
	
	
}
