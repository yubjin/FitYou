package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.WebClientService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class WebClientController {
	
	@Autowired
	private final WebClientService webService;
	
	@GetMapping("/test")
	public String getStringFromFlask() {
		return webService.getStringFromFlask();
	}
	
	@GetMapping("/style")
	public String getStyle(){
		return webService.getStyle();
	}
	@GetMapping("/styletest")
	public Flux<byte[]> getStyleTest(){
		return webService.getDataAsStream();
	}
	
}
