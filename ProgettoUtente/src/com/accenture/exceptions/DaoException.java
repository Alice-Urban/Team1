package com.accenture.exceptions;

public class DaoException extends Exception {
	public DaoException() {
		super ("oops...");
	}
	public DaoException(String messaggio) {
		super (messaggio);
		
	}
	public String getMessagge() {
		return null;
	}
}
