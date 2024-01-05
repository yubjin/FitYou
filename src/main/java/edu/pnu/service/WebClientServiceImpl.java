package edu.pnu.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

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
	public String getStringFromFlask() {
		return webClient.get()
				.uri("/test")
				.retrieve()
				.bodyToMono(String.class)
				.block(); 
	}

	@Override
	public Flux<byte[]> getDataAsStream(){	//외부 서버로부터 바이트 배열 데이터를 스트리밍으로 받음
		return webClient.get()
				.uri("/test")
				.retrieve()
				.bodyToFlux(byte[].class);
	}

	@Override
	public String getStyle() {
		return webClient.get()
                .uri("/test")
                .retrieve()
                .bodyToFlux(byte[].class)							//응답 본문을 Flux<byte[]>로 변환
                .map(chunk -> new String(chunk))					// 각 데이터 청크를 문자열로 변환
                .collectList()										//위에서 변환한 문자열 청크를 리스트로 수집함
                .map(stringChunks -> String.join("", stringChunks))	// 모든 문자열을 결합
                .block();
	}
}
