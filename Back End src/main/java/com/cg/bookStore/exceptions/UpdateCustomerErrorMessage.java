package com.cg.bookStore.exceptions;

public class UpdateCustomerErrorMessage {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UpdateCustomerErrorMessage() {
		super();
		
	}

	public UpdateCustomerErrorMessage(String message) {
		super();
		this.message = message;
	}
	
	
}
