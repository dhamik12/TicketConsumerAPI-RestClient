package com.telusko.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telusko.model.Passenger;
import com.telusko.model.Ticket;

@Service
public class TicketService implements ITicketService {
	
	

	private static final String BOOK_URL = "http://localhost:8084/producer/book-ticket";
	private static final String TICKET_URL = "http://localhost:8084/producer/get-ticket/{ticketNumber}";

	@Override
	public Ticket generateTicket(Passenger passenger) {
		System.out.println("We are registering the passenger with below details -"+passenger);
		int num=10/0;
		RestTemplate template=new RestTemplate();
		ResponseEntity<Ticket> response = template.postForEntity(BOOK_URL, passenger, Ticket.class);
		return response.getBody();
	}

	@Override
	public Ticket viewFullTicket(Integer ticketNumber) {
		RestTemplate template2=new RestTemplate();
		//template.postForEntity(TICKET_URL, ticketNumber,Ticket.class);
		ResponseEntity<Ticket> response2 = template2.getForEntity(TICKET_URL, Ticket.class, ticketNumber);
		return response2.getBody();
	}

}
