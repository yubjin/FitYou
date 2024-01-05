package edu.pnu.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MyClientService {
	private final WebClient webClient;

	public MyClientService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://10.125.121.210:5000").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
	public String getStringFromFlask() {
		return webClient.get()
				.uri("/test")
				.retrieve()
				.bodyToMono(String.class)
				.block(); 
	}
}
