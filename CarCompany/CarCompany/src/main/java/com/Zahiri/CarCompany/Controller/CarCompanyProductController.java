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
import org.springframework.web.bind.annotation.RestController;

import com.Zahiri.CarCompany.Entity.Product;
import com.Zahiri.CarCompany.Service.CustomerService;
import com.Zahiri.CarCompany.Service.ProductService;

@RestController
@RequestMapping("/api/productApi") // API for product controller
@CrossOrigin(origins="*" , allowedHeaders = "*") 
public class CarCompanyProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService; 
	
	@GetMapping("/hello")
	public String hello() {
		return "hello World From Product";
	}
	
	

	
	
	// mapping for getting all the products 
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<>(productService.getProduct(),HttpStatus.OK);
	}
	
	// add mapping for product
	@PostMapping("product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id , @RequestBody Product product){
		return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
	}
	
	
	
	
	
}
