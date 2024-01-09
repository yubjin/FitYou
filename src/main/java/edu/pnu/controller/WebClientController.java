package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.WebClientService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebClientController {
	
	@Autowired
	private final WebClientService webService;
	
	@GetMapping("/style")
	public String getStyle(){
		return webService.getStyle();
	}

	@PostMapping("/style")
	public void fetchData() {
		webService.fetchDataAndSaveToDb();
	}

}
