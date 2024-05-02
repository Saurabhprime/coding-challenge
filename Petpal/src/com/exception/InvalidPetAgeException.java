package com.exception;

public class InvalidPetAgeException extends Exception {
	private static final long serialVersionUID = 106867174289775193L;
	private String message;

	public InvalidPetAgeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}