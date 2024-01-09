package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dto.ProductDTO;
import edu.pnu.service.WebClientService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebClientController {
	
	@Autowired
	private final WebClientService webService;
	
	@PostMapping("/test")
	public String getStringFromFlask(@RequestBody ProductDTO productDTO) {
		
//		webService.jsonReader();
		return "";
	}
	
	@GetMapping("/style")
	public String getStyle(){
		return webService.getStyle();
	}

	@PostMapping("/style")
	public void fetchData() {
		webService.fetchDataAndSaveToDb();
	}

}
