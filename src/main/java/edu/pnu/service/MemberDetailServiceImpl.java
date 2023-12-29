package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Customer;
import edu.pnu.domain.Member;
import edu.pnu.persistence.CustomerRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberDetailServiceImpl implements MemberDetailService {
	private final CustomerRepository cusRepo;
	private final MemberRepository memRepo;
	
	@Override
	public List<Customer> getCusHistory(int cusNum) {
		System.out.println("cusNum="+cusNum);
		List<Customer> cusHistory = cusRepo.findAllByCusNum(cusNum);
		System.out.println("cusHistory=" + cusHistory);
		return cusHistory;
	}
	
	@Override
	public boolean isLike(int cusNum) {
		Optional<Member> findLike = memRepo.findByCusNum(cusNum);
		return findLike.isPresent();
	}

}
