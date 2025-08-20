package com.telusko.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telusko.exception.ErrorDetails;
import com.telusko.exception.TicketNotFoundException;

@RestControllerAdvice
public class ConsumerAdvice {
	
	
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<ErrorDetails> ticketNotFoundException(TicketNotFoundException tnfe){
		
		
		ErrorDetails error=new ErrorDetails();
		error.setMsg(tnfe.getMessage());
		error.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> generalException(Exception e){
		
		
		ErrorDetails error=new ErrorDetails();
		error.setMsg(e.getMessage());
		error.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
	}
}
	