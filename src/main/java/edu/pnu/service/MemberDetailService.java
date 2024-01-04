package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.CustomerImg;
import edu.pnu.dto.LikeDTO;

public interface MemberDetailService {

	List<CustomerImg> getCusHistory(int cusNum);

	boolean isLike(int cusNum);

	void insertLike(LikeDTO likeDto);

}