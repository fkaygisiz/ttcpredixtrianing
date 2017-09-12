package com.ge.ttcpredixtraining.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/say-hello")
	public String sayHelloWorld() {
		return "Hello World";
	}

}
