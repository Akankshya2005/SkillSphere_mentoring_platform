package com.example.demo.exception;



public class MenteeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    public MenteeNotFoundException(String message) {
        super(message);
    }
}