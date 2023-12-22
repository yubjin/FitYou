package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
class FitYouApplicationTests {
	
	@Autowired
	MemberRepository memRepo;

	//@Test
	public void Loads() {
		memRepo.save(Member.builder()
				.username("admin")
				.pwd("abcd")
				.role(Role.ROLE_ADMIN)
				.age(30)
				.build());
	}

}
