package com.cpena.previred.backend.apirest.sevice.dtos.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreviredError {
	
	private String errorMessage;
	private String errorCode;
	
	public PreviredError(String errorMessage, String errorCode) {		
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public PreviredError(String errorMessage) {		
		this.errorMessage = errorMessage;
	}
	
	
	

}
