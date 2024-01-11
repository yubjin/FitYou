package edu.pnu.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;

import edu.pnu.domain.CustomerImg;
import edu.pnu.domain.Member;
import edu.pnu.domain.MemberLike;
import edu.pnu.dto.LikeDTO;
import edu.pnu.persistence.CategoryRepository;
import edu.pnu.persistence.CustomerImgRepository;
import edu.pnu.persistence.MemberLikeRepository;
import edu.pnu.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberDetailServiceImpl implements MemberDetailService {
	private final CustomerImgRepository cusRepo;
	private final MemberRepository memRepo;
	private final CategoryRepository cateRepo;
	private final MemberLikeRepository memlikeRepo;
	
	@Override
	public List<CustomerImg> getCusHistory(int cusNum) {
		System.out.println("cusNum="+cusNum);
		List<CustomerImg> cusHistory = cusRepo.findAllByCusNumOrderBySellDtDesc(cusNum);
		System.out.println("cusHistory=" + cusHistory);
		return cusHistory;
	}
	
	@Override
	public boolean isLike(int cusNum) {
		Optional<Member> findLike = memRepo.findByCusNum(cusNum);
		return findLike.isPresent();
	}

	@Override
	public void insertLike(LikeDTO likeDto) {
		List<String> likelist = likeDto.getLike();
		for(int i=0; i<likelist.size();i++) {
			Member m = memRepo.findById(likeDto.getSeq()).get();
			MemberLike memlike = MemberLike.builder()
					.member(m)
					.category(cateRepo.findSeqByName(likelist.get(i)))
					.build();
		
			memlikeRepo.save(memlike);
		}
	}

	@Override
	public List<MemberLike> getLike(String token) {
		Map<String, Claim> member = JWT.decode(token).getClaims();
		Member findMember = memRepo.findByUsername(member.get("id").asString()).get();
		List<MemberLike> memlike = memlikeRepo.findByMemberSeq(findMember.getSeq());
		return memlike;
	}

}
