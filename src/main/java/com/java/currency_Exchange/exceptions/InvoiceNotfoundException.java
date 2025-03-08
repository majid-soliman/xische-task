package com.java.currency_Exchange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvoiceNotfoundException extends RuntimeException {

	  private static final long serialVersionUID = 7428051251365675318L;

	  private String message;
	
	public InvoiceNotfoundException(String message) {
		super(message);
	}
	
}
