package com.brillio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillio.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}





