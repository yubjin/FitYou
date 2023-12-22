package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class SecurityUserDetailService implements UserDetailsService{

	@Autowired private MemberRepository memRepo;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Member member = memRepo.findByUsername(id).orElseThrow(()->
		new UsernameNotFoundException("Not Found!"));
		return new User(member.getUsername(), member.getPwd(),
		AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}
