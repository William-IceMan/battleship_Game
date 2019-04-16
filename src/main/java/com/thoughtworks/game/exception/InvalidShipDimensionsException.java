package com.thoughtworks.game.exception;

public class InvalidShipDimensionsException extends RuntimeException {

	private static final long serialVersionUID = 2304611209926694026L;

	public InvalidShipDimensionsException(){
		super();
	}
	
	public InvalidShipDimensionsException(String s){
		super(s);
	}
}
