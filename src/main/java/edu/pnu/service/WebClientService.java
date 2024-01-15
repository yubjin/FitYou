package edu.pnu.service;

import java.util.List;

public interface WebClientService {

	//Mono<String> getStringFromFlask();
	String getDataFromFlask(List<String> selectList);

	String getStyle();

	void fetchDataAndSaveToDb();


}
