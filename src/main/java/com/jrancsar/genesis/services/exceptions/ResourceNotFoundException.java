package com.jrancsar.genesis.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object objeto) {
		super("Resource not found. "+ objeto);
	}
}
