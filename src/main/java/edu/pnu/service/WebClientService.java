package edu.pnu.service;

import reactor.core.publisher.Mono;

public interface WebClientService {

	Mono<String> getStringFromFlask();

}
