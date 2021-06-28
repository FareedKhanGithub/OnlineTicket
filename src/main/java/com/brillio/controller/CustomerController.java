package com.brillio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.entity.Customer;
import com.brillio.entity.Ticket;
import com.brillio.service.CustomerService;
import com.brillio.service.TicketService;







//@RestController

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	//private TicketService ticketService;			//since autowired we now have access to these methods   //but as of right now there is not a use

	private CustomerService customerService;
	
	private int whatid = 0;				//make both of these private
	private boolean what = false;
	
	@Autowired
	public CustomerController(CustomerService theCustomerService) {					//customer Service needs to be implemented
		 customerService = theCustomerService;
	}
	
	
	
	
	@GetMapping("/newone")
	public String showNewone(Model theModel){
		
		
							//list only one when entirely new user
		Customer theCustomer = customerService.findById(whatid);
		theModel.addAttribute("customers", theCustomer);
		
		return "Customer/list-customer";					//list-customer can show one or many 
		}
			
	
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		
		what = true;						//Double truths can develope
		whatid = theId;
		
		// delete the employee
		customerService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:list";
		
	}
	
	
	
	
	
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
	
		
		customerService.save(theCustomer);							//somewhere inside this file there is error in signing up
		
		whatid = theCustomer.getId();
		
		if(what == true) {
			theCustomer.setId(whatid);					//when updating the credential want to make sure the same id is still there
											//I onder what would happen to the tickets. I would then also put the tickets and set away jsut liek this
			what = false;
		}
		
	//	if(theId > 0){
		//		theModel.addAttribute("customers", theCustomer);			//theID is not there
		//}
	
		// use a redirect to prevent duplicate submissions
		//what = true;
		
									//	return "Customer/list";   
		return "redirect:newone";			//two option global variable
									//return "redirect:list";				 //you should later have just findby id version of this. 
	}												//should put it on the login page. 
	
	
	
	
	
	
	
	@GetMapping("/CustomerUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {
		
		what = true;
		whatid = theId;
		Customer theCustomer = customerService.findById(theId);    //from the db using JPA
		
		theModel.addAttribute("customer", theCustomer);
		
	
							//return "Customer/CustomerUpdateDeleteForm";			//this page will change to the login page once done. 
		return "Customer/CustomerForm";
	}
	
	
	
	@GetMapping("/CustomerSignUp")
	public String showFormForAdd(Model theModel) {

				// create model attribute to bind form data
		Customer theCustomer = new Customer();				//using the constructor for instilling
				//Ticket theTicket = new Ticket();


		theModel.addAttribute("customer", theCustomer);			//gets all the input into spring


				//theModel.addAttribute("customer", theTicket);        //was possibly usefaull for something

		return "Customer/CustomerForm";          //save was put here
	}

	
	
	
	
	

	/*				No longer in use showing all customer is not a feature I would want
												//we should not have all the customers shown to the user having this here for seeing
	@GetMapping("/list") 
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomer = customerService.findAll();
		theModel.addAttribute("customers", theCustomer);
		return "Customer/list-customer";
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Request Param is overratedglobal variable									//possibly need to function as the parameter will be miss matching 
/*@GetMapping("/listone")
public String showOnlyone(@RequestParam("id") int theId, Model theModel){


			//list only one when entirely new user
		////list only one when it has been updated so we use the Request Params

Customer theCustomer = customerService.findById(theId);    //from the db using JPA      

theModel.addAttribute("customers", theCustomer);

return "Customer/list-customer";			//list-customer can show one or many 
}*/
	
	
	
	/*
	@PostMapping("/saveUpdate")
	public String saveUpdateCustomer(@RequestParam("id") int theId,  Model theModel) {
		
		//Customer theCustomesr = customerService.findById(theId);
		
		//customerService.save(theCustomer);							//somewhere inside this file there is error in signing up
		//Customer theCustomer = customerService.findById(theId); 
		// use a redirect to prevent duplicate submissions
		
		
		System.out.println(theId);
		
	   Customer heCustomer = customerService.findById(theId);    //from the db using JPA
		
		//isnt save the same
		
		theModel.addAttribute("customer", heCustomer);
		
		
	//	return "Customer/list";              
		return "redirect:list";				 //you should later have just findby id version of this. 
	}		
	
	*/
	
	
	
	

	
	// Unknown column 'tickets1_.ticket_id' in 'field list'   what does this error mean 
	
	
}
