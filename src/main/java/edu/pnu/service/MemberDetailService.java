package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.Customer;

public interface MemberDetailService {

	List<Customer> getCusHistory(int cusNum);

	boolean isLike(int cusNum);

}