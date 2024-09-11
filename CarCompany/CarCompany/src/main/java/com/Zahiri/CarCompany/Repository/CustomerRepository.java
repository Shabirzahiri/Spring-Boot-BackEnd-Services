package com.Zahiri.CarCompany.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Zahiri.CarCompany.Entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	List<Customer> findByLastName(String LastName);

}
