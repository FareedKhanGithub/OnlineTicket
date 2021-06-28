package com.brillio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brillio.dao.CustomerRepository;
import com.brillio.entity.Customer;




@Service
public class CustomerServiceImpl implements CustomerService{					 
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository thecustomerRepository) {
		customerRepository = thecustomerRepository;
	}

	
											
	@Override														//once this is implemented there will be no errors
	public List<Customer> findAll() {
		//return ((Object) customerRepository).findAllByOrderByLastNameAsc();
		
		
		return customerRepository.findAll();
	}
    



	@Override
	public Customer findById(int theid) {															//???something strange here theid may not exist   but we use regular id in both pojo
		Optional<Customer> result = customerRepository.findById(theid);
		
		Customer theCustomer = null;   //placeholder
		
		if (result.isPresent()) {
			theCustomer = result.get();
		}
		else {
			// we didn't find the customer
			throw new RuntimeException("Did not find customer id - " + theid);
		}
		
		return theCustomer;
	}
	
	
	
	
	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
		
	}

	@Override
	public void deleteById(int id) {
		customerRepository.deleteById(id);
		
	}



	
}
