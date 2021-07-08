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
	
	private int storid = 0;				//make both of these private
	private boolean storbool = false;
	
	@Autowired
	public CustomerController(CustomerService theCustomerService) {					//customer Service needs to be implemented
		 customerService = theCustomerService;
	}
	
	
	
	
	
	
	//We dont want a list of the customer as this will actually make things more complicated. owever we dont need to put it inside the bean though. 
	
	
	
	
	
											//the old new one I realized that this is the only method needs the stor method 
	@GetMapping("/newone")
	public String showNewone(Model theModel){
		
		
							//list only one when entirely new user     one of the few times Where I need to grab the storid
		Customer theCustomer = customerService.findById(storid);
		theModel.addAttribute("customer", theCustomer);					//Where Customers coming from?  This customer maps to the html hence we can
																//go down its list and put in the infromation we want
		
		return "Customer/list-customer";					//list-customer can show one or many 
		}
	
	
	
	
											//you were trying to solve this but Post doesnt allow the passing of the id regardless though
		 											//I would think customer entity would have the id in the first place considering it is auto generated 
	
	/*
	@GetMapping("/newone")
	public String showNewone(@RequestParam("id") int theId, Model theModel){
		
		
							//list only one when entirely new user     one of the few times Where I need to grab the storid
		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("customer", theCustomer);					//Where Customers coming from?  This customer maps to the html hence we can
																//go down its list and put in the infromation we want
		
		return "Customer/list-customer";					//list-customer can show one or many 
		}
	*/
	
	
	
	
	
	
	
	
	
	@GetMapping("/CustomerDelete")
	public String formDelete(@RequestParam("id") int theId) {
		
		
		
		
		customerService.deleteById(theId);
		
		
		//return "redirect:list";
		//return "Customer/CustomerForm";	
		return "redirect:CustomerSignUp";
	}
	
	
	
	
	
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
	
		
		customerService.save(theCustomer);							//somewhere inside this file there is error in signing up
		
		storid = theCustomer.getId();
		
		if(storbool == true) {
			theCustomer.setId(storid);					//when updating the credential want to make sure the same id is still there
											//I onder what would happen to the tickets. I would then also put the tickets and set away jsut liek this
			storbool = false;
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
		
		storbool = true;
		storid = theId;
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
	