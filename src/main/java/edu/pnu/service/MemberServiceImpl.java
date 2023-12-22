package edu.pnu.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.dto.MemberDTO;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	private final MemberRepository memRepo;
	private final PasswordEncoder passwordEncoder;
	
	SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

	@Override
	public String join(MemberDTO memDTO) {
		memDTO.encodingPassword(passwordEncoder);
		Member mem = Member.builder()
				.username(memDTO.getUsername())
				.pwd(memDTO.getPwd())
				.age(memDTO.getAge())
				.cusNum(memDTO.getCusNum())
				.styleInfo(memDTO.getStyleInfo())
				.regidate(localTime)
				.role(Role.ROLE_MEMBER)
				.build();
		
		return memRepo.save(mem).getUsername();
	}
	@Override
	public boolean getMember(String id) {
		boolean isExist = false;
		Optional<Member> findMember = memRepo.findByUsername(id);
		System.out.println(findMember);
		if (findMember.isPresent()) 
			isExist = true;
		
		return isExist;
	}
	
	
}
