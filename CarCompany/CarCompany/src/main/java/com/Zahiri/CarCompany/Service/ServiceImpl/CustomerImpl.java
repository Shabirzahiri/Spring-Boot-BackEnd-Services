package com.Zahiri.CarCompany.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zahiri.CarCompany.Entity.Customer;
import com.Zahiri.CarCompany.Exeption.CustomerNotFoundException;
import com.Zahiri.CarCompany.Repository.CustomerRepository;
import com.Zahiri.CarCompany.Service.CustomerService;
@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;
	@Override
	public Customer findCustomerById(int id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		}else {
			throw new CustomerNotFoundException("Customer is not available with the ID :" + id);
		}
		
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// here we add a condition for 
		if(customer.getFirstName().isBlank()|| customer.getFirstName().isEmpty() ||customer.getFirstName()==null) {
			throw new CustomerNotFoundException("Customer can not be saved in to the system");
			
		}else {
			// this is the save method 
			return repository.save(customer);
		}
		
	}

	@Override
	public String deleteCustomerById(int id) {
		Customer customer = findCustomerById(id);
		if(customer != null) {
			repository.deleteById(id);
			return "successfully deleted";
		}else {
			throw new CustomerNotFoundException("Customer ID:" + id);
		}
	}
	
	

	@Override
	public List<Customer> findAllCustomer() {
		Iterable <Customer> customers = repository.findAll();
		List<Customer> list = new ArrayList<>();
		customers.forEach(list::add);
		return list;
		
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		Customer cust = (Customer) findCustomerById(id);
		if(cust !=null) {
			if(customer.getFirstName() != null)
				cust.setFirstName(customer.getFirstName());
			if (customer.getLastName() != null)
				cust.setLastName(customer.getLastName());
			if(customer.getEmail() != null)
				cust.setEmail(customer.getEmail());
			if(customer.getPhoneNumber() != null)
				cust.setPhoneNumber(customer.getPhoneNumber());
			if(customer.getAddress() != null)
				cust.setAddress(customer.getAddress());
			if(customer.getProduct() !=null)
				cust.setProduct(customer.getProduct());
			repository.save(cust);
			return cust;
		}else {
			throw new CustomerNotFoundException("Customer with the given ID:"+ id + "is not available");
		}
	}

	@Override
	public List<Customer> findCustomerByLastName(String lastName) {
		List<Customer> list = repository.findByLastName(lastName); 
		if(!list.isEmpty()) {
			return list;
		}else {
			throw new CustomerNotFoundException("Customer is not available with given Last Name "+ lastName);
		}
	
	}
	
	

}
