package edu.pnu.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;

import edu.pnu.domain.Member;
import edu.pnu.domain.MemberLike;
import edu.pnu.domain.Product;
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
	public List<Product> getRecommend(String token){
		Map<String, Claim> member = JWT.decode(token).getClaims();
		Member findMember = memRepo.findByUsername(member.get("id").asString()).get();
		List<MemberLike> memlikeList = memlikeRepo.findByMemberSeq(findMember.getSeq());
		System.out.println("memlikeList = " + memlikeList.toString());
		List<Product> products = new ArrayList<Product>();
		for(MemberLike memlike : memlikeList) {
			System.out.println("memlike = " + memlike);
			if (memlikeList.size() < 5) {
				List<Product> temp = prodRepo.findRandImg10(memlike.getCategory().getSeq());
				products.addAll(temp);
			}
			else if (memlikeList.size() <10) {
				List<Product> temp = prodRepo.findRandImg5(memlike.getCategory().getSeq());
				products.addAll(temp);
			}
			else {
				List<Product> temp = prodRepo.findRandImg3(memlike.getCategory().getSeq());
				products.addAll(temp);
			}
		}
		Collections.shuffle(products);
		return products;
	}

	@Override
	public List<Product> getBestProduct(String category) {
		List<Product> bestProducts = prodRepo.findTopByProdCategoryOrderByRankCntDesc(category);
		return bestProducts;
	}

}
