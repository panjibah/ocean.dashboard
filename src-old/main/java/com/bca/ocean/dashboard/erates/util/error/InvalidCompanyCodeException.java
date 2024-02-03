package com.bca.ocean.dashboard.erates.util.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCompanyCodeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
}
