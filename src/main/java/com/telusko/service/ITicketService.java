package com.telusko.service;

import com.telusko.model.Passenger;
import com.telusko.model.Ticket;

public interface ITicketService {
	
	public Ticket generateTicket(Passenger passenger);
	public Ticket viewFullTicket(Integer ticketNumber);

}
