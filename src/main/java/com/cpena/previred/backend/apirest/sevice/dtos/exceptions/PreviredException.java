package com.cpena.previred.backend.apirest.sevice.dtos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import com.cpena.previred.backend.apirest.sevice.enums.ErrorMessageEnum;

import lombok.Getter;

@Getter
public class PreviredException extends ResponseStatusException{
	
	private static final long serialVersionUID = 1L;
	private final transient PreviredError error ;
	
	public PreviredException( HttpStatus status, String reason ) {
		super(status,reason);
		this.error = new PreviredError(reason);
		
		
	}

	public PreviredException(HttpStatusCode status, String reason, Throwable cause) {
		super(status, reason, cause);
		this.error = new PreviredError(reason);
	}
	
	public PreviredException( HttpStatus status, ErrorMessageEnum error ) {
		super(status, error.getMessage());
		this.error = new PreviredError(error.getMessage(), error.getCode());
	}
	
	public PreviredException( HttpStatus status, ErrorMessageEnum error, Throwable cause ) {
		super(status, error.getMessage(), cause);
		this.error = new PreviredError(error.getMessage(), error.getCode());
		
	}
	
	

}
