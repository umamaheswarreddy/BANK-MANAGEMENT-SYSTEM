package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvestmentNotFoundException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvestmentNotFoundException(String msg)
	{
		super(msg);
	}

}
