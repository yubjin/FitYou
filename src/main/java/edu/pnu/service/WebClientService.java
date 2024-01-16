package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.Product;

public interface WebClientService {

	//Mono<String> getStringFromFlask();
	List<Product> getDataFromFlask(List<String> selectList);

	String getStyle();

	void fetchDataAndSaveToDb();


}
