package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.CustomerImage;
import edu.pnu.domain.MemberLike;
import edu.pnu.dto.LikeDTO;

public interface MemberDetailService {

	List<CustomerImage> getCusHistory(int cusNum);

	boolean isLike(int cusNum);

	void insertLike(LikeDTO likeDto);

	List<MemberLike> getLike(String token);

	List<CustomerImage> getLatest(String token);

}