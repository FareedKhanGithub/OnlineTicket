package com.brillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.entity.Customer;
import com.brillio.entity.Ticket;
import com.brillio.service.CustomerService;
import com.brillio.service.TicketService;






//@RestController

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	private TicketService ticketService;			//since autowired we now have access to these methods   //but as of right now there is not a use

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService theCustomerService) {					//customer Service needs to be implemented
		 customerService = theCustomerService;
	}
	
	
	
												//we should not have all the customers shown to the user having this here for seeing
	@GetMapping("/list") 
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomer = customerService.findAll();
		theModel.addAttribute("customers", theCustomer);
		return "Customer/list-customer";
	}
	
	
	
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		
		
		
		// save the employee
		
		customerService.save(theCustomer);							//somewhere inside this file there is error in signing up
		
		// use a redirect to prevent duplicate submissions
		//return "redirect:/";
		
		return "Customer/list-customer";               //you should later have just findby id version of this. 
	}
	
	
	
	
																		
	@GetMapping("/CustomerSignUp")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();				//using the constructor for instilling
		Ticket theTicket = new Ticket();
		
		
		theModel.addAttribute("customer", theCustomer);
		
		
		theModel.addAttribute("customer", theTicket);
		return "Customer/CustomerForm";          //save was put here
	}

	
	
	
	
}
