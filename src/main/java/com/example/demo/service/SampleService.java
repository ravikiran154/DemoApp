package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.client.CyberSourceClient;
import com.example.model.ClientReferenceInformation;
import com.example.model.CyberSourceRequest;
import com.example.model.KeyInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("sampleService")
public class SampleService {
	
	private static final String SUCCESS="SUCCESS";
	
	@Autowired
	private CyberSourceClient client;
	
	@Autowired
	private ObjectMapper mapper;

	public String sayHello(String name) {
		return "Hello "+name;
	}
	
	public String invokeCyberSource() throws JsonProcessingException {
		CyberSourceRequest cyberSourceRequest = new CyberSourceRequest();
		List<KeyInformation>keyInfos = new ArrayList<>();
		ClientReferenceInformation clientReferenceInformation = new ClientReferenceInformation();
		clientReferenceInformation.setCode("code");
		cyberSourceRequest.setClientReferenceInformation(clientReferenceInformation);
		
		KeyInformation keyInformation1 = new KeyInformation();
		keyInformation1.setOrganizationId("organization_id");
		keyInformation1.setReferenceNumber("ref_number");
		keyInfos.add(keyInformation1);
		cyberSourceRequest.setKeyInformation(keyInfos);
		
		String requestJson = mapper.writeValueAsString(cyberSourceRequest);
		ResponseEntity<String>responseEntity = client.invoke(requestJson);
		return responseEntity.getBody();
	}

	
}
