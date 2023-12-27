package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Customer;
import edu.pnu.persistence.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberDetailServiceImpl implements MemberDetailService {
	private final CustomerRepository cusRepo;
	
	@Override
	public List<Customer> getCusHistory(int cusNum) {
		System.out.println("cusNum="+cusNum);
		List<Customer> cusHistory = cusRepo.findAllByCusNum(cusNum);
		System.out.println("cusHistory=" + cusHistory);
		return cusHistory;
	}

}
