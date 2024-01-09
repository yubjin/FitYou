package edu.pnu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Member;
import edu.pnu.dto.MemberDTO;
import edu.pnu.service.MemberService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberController {
	
	private final MemberService memService;

	
	@PostMapping("/join")
	@ResponseBody
	public Member join(@RequestBody MemberDTO memDTO) {
		Member mem = memService.join(memDTO);
		return mem;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteMember(@RequestParam String pwd, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
		if (token != null && token.startsWith("Bearer ")) {
			String jwtToken = token.substring(7);
			boolean isDelete = memService.deleteMember(jwtToken, pwd);
			if (isDelete)
				return ResponseEntity.ok("");
			else {
				return ResponseEntity.badRequest().body("");
			}
		}
		return ResponseEntity.badRequest().body("");
	}
	
	@GetMapping("/idcheck")
	public boolean isMember(String id) {
		boolean isExist = memService.isMember(id);
		return isExist;
	}
	
	@GetMapping("/survey")
	public boolean isLike(String cusNum) {
		if (cusNum == "")
			return false;
		else 
			return true;
	}
	

}
