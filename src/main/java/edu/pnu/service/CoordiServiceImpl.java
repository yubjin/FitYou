package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Product;
import edu.pnu.persistence.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoordiServiceImpl {
	private final ProductRepository prodRepo;
	
	public List<Product> getAllProduct(int page, int itemsPerPage) {
		List<Product> prodList = prodRepo.findAll();
		int startIndex = (page - 1) * itemsPerPage;
		int endIndex = Math.min(startIndex + itemsPerPage, prodList.size());
		
		return prodList.subList(startIndex, endIndex);
	}
	
	public List<Product> getProduct(int page, int itemsPerPage, String category) {
		List<Product> prodList = prodRepo.findByProdCategory(category);
		int startIndex = (page - 1) * itemsPerPage;
		int endIndex = Math.min(startIndex + itemsPerPage, prodList.size());
		
		return prodList.subList(startIndex, endIndex);
	}
	

}
