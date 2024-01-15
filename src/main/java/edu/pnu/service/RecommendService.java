package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.Product;

public interface RecommendService {

	List<Product> getRecommend(String token);

	List<Product> getBestProduct(String category);


}