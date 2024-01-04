//package edu.pnu.controller;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import edu.pnu.service.ImagesService;
//import lombok.AllArgsConstructor;
//
//@RestController
//@AllArgsConstructor
//public class ImageController {
//	
//	private final ImagesService imService;
//	
//	@GetMapping("/userimg")
//	public ResponseEntity<?> getUserImg(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestParam int cusNum){
//		if (token != null && token.startsWith("Bearer ")) {
//			
//			String jwtToken = token.substring(7);
//			
//			return ResponseEntity.ok(imageDto);
//		}
//		
//		return ResponseEntity.badRequest().body("");
//	}
//	
//
//
//}