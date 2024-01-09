package edu.pnu.service;

public interface WebClientService {

	//Mono<String> getStringFromFlask();
	String getDataFromFlask();

	String getStyle();

	void fetchDataAndSaveToDb();


}
