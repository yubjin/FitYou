package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.MemberDetail;

public interface MemberDetailRepository  extends JpaRepository<MemberDetail, Long>{
	List<MemberDetail> findAllByCusNum(int cusNum);
}
