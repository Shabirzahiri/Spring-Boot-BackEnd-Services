package com.Zahiri.CarCompany.Exeption;

public class CustomerNotFoundException extends RuntimeException{

	
	public CustomerNotFoundException() {
		super();
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message,cause);
	}
}
