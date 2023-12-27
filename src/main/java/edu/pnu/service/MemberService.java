package edu.pnu.service;

import edu.pnu.domain.Member;
import edu.pnu.dto.MemberDTO;

public interface MemberService {
	String join(MemberDTO memDTO);

	boolean getMember(String id);

	Member getMypage(String token);

	boolean deleteMember(String jwtToken, String pwd);
}
