package com.thoughtworks.game.exception;

public class InvalidBattleAreaException extends RuntimeException {

	private static final long serialVersionUID = -4737858985380728680L;

	public InvalidBattleAreaException(){
		super();
	}
	
	public InvalidBattleAreaException(String s){
		super(s);
	}
}
