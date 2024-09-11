package com.Zahiri.CarCompany.Service;

import java.util.List;

import com.Zahiri.CarCompany.Entity.Product;


public interface ProductService {
	
	public List<Product> getProduct();
	public Product findProductById(int id);
	public Product saveProduct(Product product);
	public String deleteProductById(int id);
	public Product updateProduct(int id, Product product);
	
	

}
