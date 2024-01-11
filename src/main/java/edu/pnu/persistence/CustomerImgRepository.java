package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.CustomerImg;

public interface CustomerImgRepository extends JpaRepository<CustomerImg, Long> {

	List<CustomerImg> findAllByCusNumOrderBySellDtDesc(int cusNum);

}
