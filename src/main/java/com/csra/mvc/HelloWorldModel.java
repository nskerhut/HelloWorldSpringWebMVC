package com.csra.mvc;

public class HelloWorldModel {
	private String greeting;

	/**
	 * @return the greeting
	 */
	public String getGreeting() {
		return greeting;
	}

	/**
	 * @param greeting the greeting to set
	 */
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public HelloWorldModel(){}
	public HelloWorldModel(String msg){
		this.greeting = msg;
	}
}
