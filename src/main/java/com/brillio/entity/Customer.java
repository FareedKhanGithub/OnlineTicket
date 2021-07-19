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
	

	
	
	
	
	
	
	//-------------------------------------------------------------
	
	
		//we share the entity					//Need to make changes in the controller and thymeleaf as well. and sql database 
		
		
		
		
		@Column(name = "emailr")
		private String emailr;								//in the future it will be email  I am just putting this for being in line with tuts
		



	

		@Column(name = "password")
		private String password;
		
		
		
		


		@Column(name = "active")
		private boolean active;			//user needs to be active so spring security can now  compare weather this person is in the system or not. 
		
		
		@Column(name = "roles")
		private String roles;				//I am not entire ly sure why have this but it allows the future proofing which is nice. 
														//there isnt going to be a admin role so will be wide open as everyone is a customer who is using this.
											//Koushik is going ot be using this for csv but the general case will happen soon. 
		
		//-------------------------------------------------------------
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					//which id is this referring to.  I think to the local variable here.  
	@JoinColumn( name = "id", referencedColumnName = "id")				
	@OneToMany(fetch = FetchType.EAGER)
	private List<Ticket> tickets;
																	//how does this 
	
	//-------------------------------------------------------------
	
	
	
	
	

	public Customer() {}

	


	public Customer(int id, String name, String contact, String address, String emailr, String password, boolean active,
			String roles, List<Ticket> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.emailr = emailr;
		this.password = password;
		this.active = active;
		this.roles = roles;
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
	
	
	//-------------------------------------
	
	public String getEmailr() {
		return emailr;
	}




	public void setEmailr(String emailr) {
		this.emailr = emailr;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public boolean isActive() {
		return active;
	}




	public void setActive(boolean active) {
		this.active = active;
	}




	public String getRoles() {
		return roles;
	}




	public void setRoles(String roles) {
		this.roles = roles;
	}

	//------------------------------------------------------
	
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
























