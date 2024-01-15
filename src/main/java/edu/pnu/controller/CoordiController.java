package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Product;
import edu.pnu.service.CoordiServiceImpl;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CoordiController {

	private final CoordiServiceImpl coordiService;  
	
	@GetMapping("getAll")
	public List<Product> getAllProduct(@RequestParam int page, @RequestParam int itemsPerPage) {
		List<Product> prodList = coordiService.getAllProduct(page, itemsPerPage);
		return prodList;
	}
	
	@GetMapping("getProd")
	public List<Product> getProduct(@RequestParam int page, @RequestParam int itemsPerPage, @RequestParam String category) {
		List<Product> prodList = coordiService.getProduct(page, itemsPerPage, category);
		return prodList;
	}
}
