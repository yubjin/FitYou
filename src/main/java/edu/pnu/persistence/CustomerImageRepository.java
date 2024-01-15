package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.CustomerImage;

public interface CustomerImageRepository extends JpaRepository<CustomerImage, Long> {

	List<CustomerImage> findAllByCusNumOrderBySellDtDesc(int cusNum);
	
	@Query(value="SELECT * FROM customer_image WHERE cus_num = :cusnum AND (prod_code LIKE 'AI%' OR prod_code LIKE 'AH%') ORDER BY sell_dt DESC", nativeQuery = true)
	List<CustomerImage> findlatest(@Param("cusnum") int cusNum);

}
