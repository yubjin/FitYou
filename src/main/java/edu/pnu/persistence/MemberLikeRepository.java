package edu.pnu.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.MemberLike;

public interface MemberLikeRepository extends JpaRepository<MemberLike, Long>{

	Optional<MemberLike> findBySeq(int cusNum);

}
