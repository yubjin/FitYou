package edu.pnu.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.domain.CustomerImage;
import edu.pnu.domain.Product;
import edu.pnu.persistence.CustomerImageRepository;
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
	
	@Autowired
	private CustomerImageRepository cusRepo;
	
	public WebClientServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder
				.baseUrl("http://10.125.121.155:5000")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				
				.build();
	}
	
	@Override
	public List<Product> getDataFromFlask(List<String> selectList) {		//flask에 제품 코드 5개 보내고 추천데이터 받아오기
		//List<String> prodList = productRepo.find2021(); 			//2021년도 제품을 랜덤으로 가져오기
		System.out.println(selectList);
		List<Product> prodList = new ArrayList<Product>();
		String response =  webClient.post()
				.uri("/test")
				.bodyValue(selectList)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		// ObjectMapper를 사용하여 JSON을 Java 객체로 매핑
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode;
		try {
			rootNode = objectMapper.readTree(response);
			// 배열에 접근
			JsonNode recommendList = rootNode.get("recommend_list");
			System.out.println("recommendList = " + recommendList);
			List<String> combineList = new ArrayList<String>();
			
			for (JsonNode tempList: recommendList) {
				for (JsonNode tempString: tempList) {
					combineList.add(tempString.asText());
				}
			} 
			
			for (String tempString: combineList) {
				prodList.addAll(productRepo.findByProdCode(tempString));
			}
			System.out.println("prodList = " + prodList);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return prodList;
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
