package edu.pnu.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class WebClientServiceImpl implements WebClientService{
	private final WebClient webClient;

	public WebClientServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder
				.baseUrl("http://10.125.121.210:5000")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	@Override
	public Mono<String> getStringFromFlask() {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/test").build())
				.retrieve()
				.bodyToMono(String.class)
				.onErrorResume(throwable ->Mono.just("Error: " +throwable.getMessage())); 
	}
}
