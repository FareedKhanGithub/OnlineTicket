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
	
	
	/*@OneToMany(mappedBy="customer",
	cascade = {CascadeType.PERSIST, CascadeType.MERGE,
     CascadeType.DETACH, CascadeType.REFRESH})
	 private List<Ticket> tickets;			*/
	
	 
	 /*
	   									//MAJOR         realized that maybe Andrew db had changed quite a bit I should have my side setup as much as possible
	  @OneToMany(mappedBy="customer",
	 cascade = CascadeType.ALL)
	 private List<Ticket> tickets = new ArrayList<>();		 */    //cant have a null spaced arraylist 
	 
	 
	 //private List<Ticket> tickets;  
	 
	 
											//jsut do all lol      //cant be null foriegn is a non null unique identifier
	
	 
	 
	 
	 /*@OneToMany(mappedBy="ticket_id",
     cascade = CascadeType.ALL)
	 @JoinColumn( name = "ticket_id", referencedColumnName = "id")
	 private List<Ticket> ticketd = new ArrayList<>();		 */	//the arraylist already exist mostly 
	 
	 
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

	
	public Customer(int id, String name, String contact, String address) {   //,List<Ticket> tickets) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		//this.tickets = tickets;
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
	
	

	/*											Major
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























