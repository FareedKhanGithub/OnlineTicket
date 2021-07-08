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

import com.brillio.entity.Customer;
import com.brillio.entity.Ticket;
import com.brillio.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	//load tickets
	//private List<Ticket> tickets
	private TicketService ticketService;
	
	
	private Customer cust;
	
	
	@Autowired
	public TicketController(TicketService theTicketService) {
		 ticketService = theTicketService;
	}
	
	@GetMapping("/list") 
	public String listTickets(Model theModel) {									//This is not the input 
		
		List<Ticket> theTicket = ticketService.findAll();    //might be where the issue is
		theModel.addAttribute("tickets", theTicket);
		return "tickets/list-tickets";
	}
	
	
	
												//potential for needing the customer id
	@GetMapping("/showFormForBuy")
	public String showFormForBuy(Model theModel) {				
		Ticket theTicket = new Ticket();
		
		theModel.addAttribute("ticket", theTicket);
		
		return "tickets/buy-form";
	}
	
	
		
	@PostMapping("/buy")
	public String saveTicket(@ModelAttribute("ticket") Ticket theTicket) {      //instilled into the model  we simply save it
		//save the employee
				//need data object I wonder if it will consider this. 
		
		
										//date string is merely saved realy soley on the JPA repository with no regards 
							//wy of converting the string input into a data object that can be stored properly. so taht the sql can register it properly. 
		
			ticketService.save(theTicket);	
		//////////////////////////////////////////////////////////
		
		
		/*
			storid = theCustomer.getId();
			
			if(storbool == true) {
				theCustomer.setId(storid);					//when updating the credential want to make sure the same id is still there
												//I onder what would happen to the tickets. I would then also put the tickets and set away jsut liek this
				storbool = false;
			}
		*/
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////////////
	
		System.out.println("this is the id " + theTicket.getId());			//this i wonder
		//System.out.println("this is the id of the customer " + cust.getId());	            //this just might be the error 
		System.out.println("this is the address " + theTicket.getAddress());
		System.out.println("this is the name " + theTicket.getName());
		System.out.println("this is the Contact " + theTicket.getContact());
		System.out.println("this is the address " + theTicket.getAddress());
		
		System.out.println("this is the travel date " + theTicket.getTravelDate());			//I wonder this is in there
		System.out.println("this is the return date " + theTicket.getReturnDate());
		
		System.out.println("this is the passenger " + theTicket.getPassenger());
		
		theTicket.setCustomer(cust);	//get the private id 
		
		System.out.println("this is the passenger " + theTicket.getCustomer());       //I dont think I have ever actually got the key 
		
		///////////////////////////////////////////////////////////////////////////////
		//cust.getId();
		//theModel.addAttribute("customers", theCustomer);
		
		
		//use a redirect to prevent duplicate submissions 
		//return "redirect:/tickets/list";
		return "redirect:/tickets/list";
	}
	
	
	
	
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") int tikcetId, Model theModel) {
		
		System.out.println("**********");
		
		//get the ticket from the service
		Ticket theTicket = ticketService.findById(tikcetId);
		//set ticket as a model attribute
		
		theModel.addAttribute("ticket", theTicket);
		//send over to the form
		
		System.out.println("*********" + theTicket.getId());
		return "tickets/buy-form";
	}

	@GetMapping("/delete") 
	public String delete(@RequestParam("ticketId") int theId) {
		ticketService.deleteById(theId);
		return "redirect:/tickets/list";
	}
	
}
