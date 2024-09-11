package com.Zahiri.CarCompany.Entity;


import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column(nullable = false )
	private String CarCompany;
	private String image;
	@Column(nullable = false )
	private String Model;
	@Column(nullable = false )
	// for the using of price we need the Wrapper class so it can the null in our impl
	private Double Price;
	@Column( unique = true, nullable = false )
	private String LicensePlates;
	private String Description;
	private int rating;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String carCompany, String image, String model, Double price, String licensePlates,
			String description, int rating, Customer customer) {
		super();
		this.productId = productId;
		CarCompany = carCompany;
		this.image = image;
		Model = model;
		Price = price;
		LicensePlates = licensePlates;
		Description = description;
		this.rating = rating;
		this.customer = customer;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCarCompany() {
		return CarCompany;
	}
	public void setCarCompany(String carCompany) {
		CarCompany = carCompany;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getLicensePlates() {
		return LicensePlates;
	}
	public void setLicensePlates(String licensePlates) {
		LicensePlates = licensePlates;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
	
}
