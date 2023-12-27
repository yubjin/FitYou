package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

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

import edu.pnu.domain.Customer;
import edu.pnu.domain.Member;
import edu.pnu.dto.MemberDTO;
import edu.pnu.service.MemberDetailService;
import edu.pnu.service.MemberService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberController {
	
	private final MemberService memService;
	private final MemberDetailService memDetailService;
	
	@PostMapping("/join")
	@ResponseBody
	public String join(@RequestBody MemberDTO memDTO) {
		String memberId = memService.join(memDTO);
		return "join" + memberId;
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
	public boolean getMember(String id) {
		boolean isExist = memService.getMember(id);
		return isExist;
	}
	@GetMapping("/getmem")
	public ResponseEntity<?> getMypage(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
		List<Object> myData= new ArrayList<Object>();
		if (token != null && token.startsWith("Bearer ")) {
			String jwtToken = token.substring(7);
			Member findMember = memService.getMypage(jwtToken);
			myData.add(findMember);
			List<Customer> cusHistory = memDetailService.getCusHistory(findMember.getCusNum());
			myData.add(cusHistory);
			return ResponseEntity.ok(myData);
		}
		return ResponseEntity.badRequest().body("");
	}

}
