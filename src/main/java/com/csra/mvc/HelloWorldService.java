package com.csra.mvc;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
	private final String format = "Hello %s!!!";
	
	public String Greet(String name){
		return String.format(format, name);
	}
}
