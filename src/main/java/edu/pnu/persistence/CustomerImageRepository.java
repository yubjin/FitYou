package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.CustomerImage;

public interface CustomerImageRepository extends JpaRepository<CustomerImage, Long> {

	List<CustomerImage> findAllByCusNumOrderBySellDtDesc(int cusNum);

}
