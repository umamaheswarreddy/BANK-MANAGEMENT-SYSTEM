package com.example.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DupicatesException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DupicatesException(String msg)
	{
		super(msg);
	}

}
