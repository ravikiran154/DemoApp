package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service("sampleService")
public class SampleService {

	public String sayHello(String name) {
		return "Hello "+name;
	}

	
}
