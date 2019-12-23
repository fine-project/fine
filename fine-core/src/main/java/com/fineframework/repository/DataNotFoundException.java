package com.fineframework.repository;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException() {
	}
	
	public DataNotFoundException(String message) {
		super(message);
	}

	
}
