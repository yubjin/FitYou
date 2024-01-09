package edu.pnu.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.RecommendService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class RecommendController {
	private final RecommendService recoService;
	
	
	@GetMapping("/recommend")
	public ResponseEntity<?> getRecommend(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
		System.out.println(token);
		if (token != null && token.startsWith("Bearer ")) {
			String jwtToken = token.substring(7);
			List<String> imgUrls = recoService.getRecommend(jwtToken);
			System.out.println(imgUrls.size());
			return ResponseEntity.ok(imgUrls);
		}
		return ResponseEntity.badRequest().body("");
	}
	

}
