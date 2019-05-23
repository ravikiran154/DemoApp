package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SampleService;


@RestController
@RequestMapping("/greet")
public class SampleController {

	@Autowired
	private SampleService service;

	@RequestMapping(value = "/aop", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name ) throws IOException {
		return service.sayHello(name);
	}
	
	@RequestMapping(value = "/cyberSource", method = RequestMethod.GET)
	public String invokeCyberSource() throws IOException {
		return service.invokeCyberSource();
	}

}
