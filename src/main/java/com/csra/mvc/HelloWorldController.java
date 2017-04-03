package com.csra.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/HelloWorld")
	public HelloWorldModel HelloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return new HelloWorldModel(name);
	}
}
