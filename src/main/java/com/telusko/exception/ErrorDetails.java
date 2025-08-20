package com.telusko.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	
	
	private String msg;
	private LocalDateTime dateTime;
	
	

}
