package com.brillio.service;

import java.util.List;

import com.brillio.entity.Customer;
//import com.luv2code.springboot.thymeleafdemo.entity.Employee;






public interface CustomerService {

	public List<Customer> findAll();				//merely an interface 
	
	public Customer findById(int theId);		//theId  is what is passed in here adn the subclass below will then use it
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);			//change this as well 
}
