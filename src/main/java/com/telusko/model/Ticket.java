package com.telusko.model;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	
	private Integer ticketNumber;
	private Integer passengerId;
	private String name;
	private Integer age;
	private String gender;
	private LocalDateTime departure;
	private String boardingAt;
	private LocalDateTime arrival;
	private String destination;
	private Integer trainNumber;
	private String status;
	private Double price;
	
	

}
