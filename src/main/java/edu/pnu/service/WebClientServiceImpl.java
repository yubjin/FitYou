package edu.pnu.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import edu.pnu.domain.Product;
import edu.pnu.persistence.ProductRepository;

@Service
public class WebClientServiceImpl implements WebClientService{
	private final WebClient webClient;
	private final String Url = "http://10.125.121.210:5000/test";
	@Autowired
	private WebClient.Builder webClientBuilder;
//	@Autowired
//	private StyleRepository styleRepo;
	@Autowired
	private ProductRepository productRepo;

	public WebClientServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder
				.baseUrl("http://10.125.121.155:5000")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				
				.build();
	}
	
	@Override
	public String getDataFromFlask(List<String> selectList) {		//flask에 제품 코드 5개 보내고 추천데이터 받아오기
		//List<String> prodList = productRepo.find2021(); 			//2021년도 제품을 랜덤으로 가져오기
		System.out.println(selectList);
		String response =  webClient.post()
				.uri("/test")
				.bodyValue(selectList)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		return response;
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
	
	 public void fetchDataAndSaveToDb() {					        // flask로부터 JSON 데이터 가져오기
	        List<Product> imageData = webClientBuilder.build()		// 나인온스 데이터를 k-fashion 분류에 따른 style로 분류한 json 데이터
	                .get()
	                .uri(Url)
	                .retrieve()
	                .bodyToFlux(Product.class)
	                .collectList()
	                .block();

	        // 가져온 데이터를 DB에 저장
	        if (imageData != null) {
	            for (Product prodEntity : imageData) {
	                productRepo.save(prodEntity);
	            }
	        }
	    }
	 
	 

}
