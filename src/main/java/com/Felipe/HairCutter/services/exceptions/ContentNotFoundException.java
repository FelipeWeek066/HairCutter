package com.Felipe.HairCutter.services.exceptions;


public class ContentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ContentNotFoundException(Object id) {
		super("Resource not found. Id: " + id);
	}
}
