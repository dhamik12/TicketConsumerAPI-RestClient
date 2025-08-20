package com.telusko.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.telusko.model.Passenger;
import com.telusko.model.Ticket;
import com.telusko.service.TicketService;



@Controller
//@RequestMapping("/consumer-api")
public class ConsumerController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute Passenger passenger,Model model) {
		
		System.out.println("Passenger Object in controller"+passenger);
		 Ticket ticket = service.generateTicket(passenger);
		
		model.addAttribute("TicketNumber","Ticket Number is :"+ ticket.getTicketNumber());
		return "index";
	}
	
	@GetMapping("/get-form")
	public String leadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}
	
	@GetMapping("/check-full-ticket")
	public String getFullTicket() {
		System.out.println("We are providing from to view full ticket.");
		return "search";
	}
	
	
	@GetMapping("/full-ticket")
	public String getTicket(Model model, @RequestParam("ticketNumber") Integer ticketNumber) {
		
		System.out.println("Ticket Number :"+ticketNumber);
		Ticket ticket = service.viewFullTicket(ticketNumber);
		System.out.println(ticket);
		model.addAttribute("Ticket", ticket);
		return "fullticket";
	}

}
