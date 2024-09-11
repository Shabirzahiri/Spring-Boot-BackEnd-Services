package com.Zahiri.CarCompany.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zahiri.CarCompany.Entity.Product;
import com.Zahiri.CarCompany.Repository.ProductRepository;
import com.Zahiri.CarCompany.Service.ProductService;

@Service
public class ProductImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	
	public List<Product> getProduct() {
		Iterable<Product> products = repository.findAll();
		List<Product> list = new ArrayList<>();
		products.forEach(list::add);
		return list;
	}

	
	public Product findProductById(int id) {
		Optional<Product> product = repository.findById(id);
		return product.orElseThrow(() -> new NoSuchElementException("product Not found with id :" +id));
	}

	
	public Product saveProduct(Product product) {
		Product p = repository.save(product);
		return p ;
	}

	public String deleteProductById(int id) {
		Optional<Product> product = repository.findById(id);
		if(product.isPresent()) {
			repository.delete(product.get());
			return "Product Successfully Deleted";
		}
		return "Somthing went wrong";
	}

	
	public Product updateProduct(int id, Product product) {
		Optional<Product> prod = repository.findById(id);
		if(prod != null) {
			Product p = prod.get();
			if(product.getCarCompany()!=null) {
				p.setCarCompany(product.getCarCompany());
			}
			if(product.getModel() != null) {
				p.setModel(product.getModel());
			}
			if(product.getPrice() != null) {
				p.setPrice(product.getPrice());
			}
			if(product.getLicensePlates() != null) {
				p.setLicensePlates(product.getLicensePlates());
				
			}
			if(product.getDescription() != null) {
				p.setDescription(product.getDescription());
			}
		
			repository.save(p);
			return p ;
		}
		return product;
	}

		
}
