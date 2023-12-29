package edu.pnu.service;

import edu.pnu.domain.Member;
import edu.pnu.dto.MemberDTO;

public interface MemberService {
	Member join(MemberDTO memDTO);

	boolean isMember(String id);

	Member getMypage(String token);

	boolean deleteMember(String jwtToken, String pwd);
}
