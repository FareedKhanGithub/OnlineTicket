package com.brillio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.brillio.dao.CustomerRepository;
import com.brillio.service.TicketService;


//forign key to auto incremented Ticket.java will be needed




//probabaly should have the return date and depart date here because what is the initial form?
	//but this is for logging inso base info only???    ticket is when you have specific flight in mind

@Entity
@Table(name = "customer")
public class Customer {
	
	
	//private TicketService ticketService;
	//private Ticket ticketEnt;
	/*@Autowired
	public TicketController(TicketService theTicketService) {
		 ticketService = theTicketService;
	}
	*/
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	



	@Column(name = "name")
	private String name;
	
	@Column(name = "contact")
	private String contact;				
	
	@Column(name = "address")
	private String address;
	

					//which id is this referring to.  I think to the local variable here.  
	@JoinColumn( name = "id", referencedColumnName = "id")				
	@OneToMany(fetch = FetchType.EAGER)
	private List<Ticket> tickets;
																	//how does this 
	
	//-------------------------------------------------------------
	
	
	
	
	

	public Customer() {}

	
	public Customer(int id, String name, String contact, String address, List<Ticket> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.tickets = tickets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	public List<Ticket> getTickets() {				//The regular tickets 
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	
/*
											Major
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	
	public void setTickets(List<Ticket> tickets) {
		this.tickets = ticketService.findAll();
		//this.tickets = tickets;
	}
		

*/
	
	
	
	
	
	
	//public void setTickets(List<Ticket> tickets) {
		//it would make sense to use that service but we cant assume the customer has bought any tickets therefore this should null
		
		//tickets = ticketService.findAll();			//there could be nothing in there. that should be fine 
	  /*  if(ticketService.findAll() == null) {
			
		
			this.tickets = tickets.add(0);
			return;
		}    */  
						//this is a list in ticketService			//and if it is null?? so what
	//	this.tickets = ticketService.findAll();    // tickets;
	//}

	


	
	//ticket id as forign key  stems from here
	
	
}
























