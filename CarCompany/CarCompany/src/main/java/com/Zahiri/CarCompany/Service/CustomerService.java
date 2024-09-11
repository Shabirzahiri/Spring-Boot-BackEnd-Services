package com.Zahiri.CarCompany.Service;

import java.util.List;

import com.Zahiri.CarCompany.Entity.Customer;

public interface CustomerService {
	
	public Customer findCustomerById(int id );
	public Customer saveCustomer(Customer customer);
	public String deleteCustomerById(int id );
	public List<Customer> findAllCustomer();
	public Customer updateCustomer (int id , Customer customer);
	List<Customer> findCustomerByLastName(String lastName);


	

}
