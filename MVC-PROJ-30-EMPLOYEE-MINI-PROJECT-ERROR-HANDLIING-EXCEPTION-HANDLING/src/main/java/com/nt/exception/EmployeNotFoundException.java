package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeNotFoundException extends RuntimeException {
	public EmployeNotFoundException(String args) {
         super(args);
	
	}

}
