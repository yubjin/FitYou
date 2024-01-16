package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Product;
import edu.pnu.dto.SelectDTO;
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
	@PostMapping("/getlist")
	public ResponseEntity<?> getData(@RequestBody SelectDTO itemList) {
		List<Product> list = webService.getDataFromFlask(itemList.getSelectList());
		System.out.println(list);
		return ResponseEntity.ok(list);
	}

}
