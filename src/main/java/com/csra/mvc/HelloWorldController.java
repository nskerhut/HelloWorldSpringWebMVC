package com.csra.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {

	private final HelloWorldService service;
	
	public HelloWorldController(HelloWorldService service){
		this.service = service;
	}
	
	@RequestMapping("/HelloWorld")
	public @ResponseBody String HelloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return service.Greet(name);
	}
}
