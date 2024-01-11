package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.CustomerImage;
import edu.pnu.domain.Member;
import edu.pnu.domain.MemberLike;
import edu.pnu.dto.LikeDTO;
import edu.pnu.service.MemberDetailService;
import edu.pnu.service.MemberService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberDetailController {
	
	private final MemberService memService;
	private final MemberDetailService memDetailService;
	
	@GetMapping("/getmem")						//마이페이지 정보 불러오기
	public ResponseEntity<?> getMypage(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
		List<Object> myData= new ArrayList<Object>();
		if (token != null && token.startsWith("Bearer ")) {
			String jwtToken = token.substring(7);
			Member findMember = memService.getMypage(jwtToken);
			myData.add(findMember);
			List<CustomerImage> cusHistory = memDetailService.getCusHistory(findMember.getCusNum());
			myData.add(cusHistory);
			
			return ResponseEntity.ok(myData);
		}
		return ResponseEntity.badRequest().body("");
	}
	

	@GetMapping("/memlike")							//선호 스타일 조회
	public ResponseEntity<?> getLike(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
		if (token != null&& token.startsWith("Bearer ")) {
			String jwtToken = token.substring(7);
			List<MemberLike> memlike = memDetailService.getLike(jwtToken);
			return ResponseEntity.ok(memlike);
		}
		return ResponseEntity.badRequest().body("");
	}
	
	@PostMapping("/memlike")						//선호 스타일 DB 저장
	public ResponseEntity<?> insertLike(@RequestBody LikeDTO likeDto){
		memDetailService.insertLike(likeDto);
		return ResponseEntity.ok("");
	}
	

}
