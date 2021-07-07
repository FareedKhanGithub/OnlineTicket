package com.brillio.entity;

import java.sql.Date;								//they should connect it would automatically convert it seems 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brillio.service.CustomerService;
import com.brillio.service.TicketService;







@Entity
@Table(name="ticket")
public class Ticket {
	//define fields
	
	
	//private CustomerService customerService;
	//private Customer customerEnt;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	






	@Column(name="address")
	private String address;
	
	@Column(name="name")
	private String name;					//there is no foriegn key symbol here.
	//define constructors
	
	
	@Column(name="contact")
	private String contact;
	
	
														//As inputs they are saved as String but in the db they are saved as date 
	//@Temporal(TemporalType.DATE)												//this unit is vulnerable to errors but this should work  month/day/year
	@Column(name="travel_date")
	private Date travelDate;						//employee.setDob(new Date(0, 0 , 1932));
	
	
	//@Temporal(TemporalType.DATE)	 //Temporal makes it explicit you are dealing with dates not time hours	//if you want to track time then we would use TIMESTAMP
	@Column(name="return_date")						
	private Date returnDate;
	
	
	
	
	
	@Column(name="passenger")
	private int passenger;
	
	
	/*			//Major
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
	   CascadeType.DETACH, CascadeType.REFRESH}) //apply the rest except cascade delete
   @JoinColumn(name="ticket_id")   	 				//nullable = true   andrew sugest this but ehh      
   private Customer customer;	
	*/
		
		
		
		
		
	/*@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH}) //apply the rest except cascade delete
    @JoinColumn(name="ticket_id")
    private Customer customer;			//ticket_id is inside the table of customer
	
	*/
	
	
	//------------------Koushiks reverse side-----------------------------------------------------------
									//They need to know if they are comliementary to eachother 
							//This will own the relationship    (what does that mean?
	
	//id is not insertable nor updatable this      is this in regards to customer id or ticket id?     I am thinking customer id because that is what Customer object ref is for
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id", insertable = false, updatable = false)    				//referencedColumnName = "id")						
	private Customer customer;
	
					//only this side should have it hence the reason why I didnt need to do for login the last time. 
	
	
	//----------------------------------------------------------------------------------------------------

	public Ticket() {}


	public Ticket(int id, String address, String name, String contact, Date travelDate, Date returnDate, int passenger, Customer customer) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.contact = contact;
		this.travelDate = travelDate;
		this.returnDate = returnDate;
		this.passenger = passenger;
		this.customer = customer;
	}

	//define getter/setter
	

	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getPassenger() {
		return passenger;
	}

	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}
	
	
	public Customer getCustomer() {					//One Customer       Many Tickets
		return customer;
	}

	public void setCustomer(Customer customer) {
		//customerEnt
		this.customer = customer;  // customer;
	}
      
	



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", address=" + address + ", contact=" + contact + ", travelDate=" + travelDate
				+ ", returnDate=" + returnDate + ", passenger=" + passenger + ", name=" + name + ", customer="
				 + "]";//+ customer + "]";
	}
	
	
}
