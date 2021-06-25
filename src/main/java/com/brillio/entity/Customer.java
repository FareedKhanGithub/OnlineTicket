package com.brillio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	//private Ticket ticket;
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
	
	 @OneToMany(mappedBy="customer",
	 cascade = CascadeType.ALL)
	 private List<Ticket> tickets;
	
											//jsut do all lol      //cant be null foriegn is a non null unique identifier
	
	 
	 // tickets = ;		//I havent allocated new space for this??
	
	
	 
	 /*
	 
	 @OneToMany(mappedBy="customer",
	 cascade = CascadeType.ALL)
	 private List<Ticket> tickets = new ArrayList<>(ticketService.findAll());			//allocating new space and then filling it up using autowired
	
	  */
	 
	 
	 
	 
	/* @OneToMany(mappedBy="ticket_id",
			 cascade = CascadeType.ALL)
	 @JoinColumn( name = "")
	 private List<Ticket> tickets = new ArrayList<>();	   */
			 
			 //cascade= {CascadeType.PERSIST, CascadeType.MERGE,
				// CascadeType.DETACH, CascadeType.REFRESH})
	           //private List<Ticket> tickets = new ArrayList<>();	
	
	 //https://www.youtube.com/watch?v=Buya2plwkj4
	
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
	
	

	
	public List<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + ", tickets="
				+ tickets + "]";
	}
	
	
	//ticket id as forign key  stems from here
	
	
}
