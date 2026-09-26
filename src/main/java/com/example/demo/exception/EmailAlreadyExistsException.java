package com.example.demo.exception;



public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
