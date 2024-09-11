package com.Zahiri.CarCompany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Zahiri.CarCompany.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer > {

}
