package com.example.client;

import java.net.URI;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class CyberSourceClient {
	
	private static final String APPLICATION_JSON = "application/json";

	public ResponseEntity<String>  invoke(String request){
		RestTemplate restTemplate = getRestTemplate();
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add(HTTP.CONTENT_TYPE, APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(request, headers);
		ResponseEntity<String> response = restTemplate.exchange("enter_url", HttpMethod.POST, entity, String.class);
		return response;
	}
	
	private RestTemplate getRestTemplate() {
		RequestConfig requestConfig = RequestConfig.custom().setRedirectsEnabled(true).build();
		RestTemplate restTemplate = new RestTemplate();
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		httpClientBuilder.setDefaultRequestConfig(requestConfig);

		CloseableHttpClient httpClient = httpClientBuilder.build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient) {
			@Override
			protected org.apache.http.protocol.HttpContext createHttpContext(final HttpMethod httpMethod, final URI uri) {
				return new HttpClientContext();
			}
		};
		restTemplate.setRequestFactory(factory);
		return restTemplate;
	}
}
