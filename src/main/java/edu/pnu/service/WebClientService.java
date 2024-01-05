package edu.pnu.service;

import reactor.core.publisher.Flux;

public interface WebClientService {

	//Mono<String> getStringFromFlask();
	String getStringFromFlask();

	String getStyle();

	Flux<byte[]> getDataAsStream();

}
