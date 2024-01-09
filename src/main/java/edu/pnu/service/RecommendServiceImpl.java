package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;

import edu.pnu.domain.Member;
import edu.pnu.domain.MemberLike;
import edu.pnu.persistence.MemberLikeRepository;
import edu.pnu.persistence.MemberRepository;
import edu.pnu.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendServiceImpl implements RecommendService {
	
	private final MemberRepository memRepo;
	private final MemberLikeRepository memlikeRepo;
	private final ProductRepository prodRepo;
	
	
	@Override
	public List<String> getRecommend(String token){
		Map<String, Claim> member = JWT.decode(token).getClaims();
		Member findMember = memRepo.findByUsername(member.get("id").asString()).get();
		List<MemberLike> memlikeList = memlikeRepo.findByMemberSeq(findMember.getSeq());
		List<String> imageUrls = new ArrayList<String>();
		for(MemberLike memlike : memlikeList) {
			if (memlikeList.size() < 5) {
				List<String> temp = prodRepo.findRandImg10(memlike.getCategory().getSeq());
				imageUrls.addAll(temp);
			}
			else if (memlikeList.size() <10) {
				List<String> temp = prodRepo.findRandImg5(memlike.getCategory().getSeq());
				imageUrls.addAll(temp);
			}
			else {
				List<String> temp = prodRepo.findRandImg3(memlike.getCategory().getSeq());
				imageUrls.addAll(temp);
			}
		}
		return imageUrls;
	}
}
