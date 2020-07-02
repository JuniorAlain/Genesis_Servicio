package com.jrancsar.genesis.services.exceptions;

public class DatabaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String msg) {
		super(msg);
	}
	/*
	public DatabaseException(Object objeto) {
		super("Key "+ objeto+ " exists.");
	}
	*/
}
