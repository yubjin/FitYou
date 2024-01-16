package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> findByStyleCode(Long style);
	List<String> findImageUrlByStyleCode(Long style);

	@Query(value="SELECT prod_code FROM product WHERE prod_code LIKE 'AI%' ORDER BY RAND() LIMIT 5", nativeQuery = true)
	List<String> find2021();
	
	List<Product> findByProdCode(String code);
	List<Product> findByProdCategory(String category);

	@Query(value= "SELECT * FROM product WHERE style_code = :style ORDER BY RAND() LIMIT 5", nativeQuery = true)
	List<Product> findRandImg5(@Param("style") Long style);

	
	@Query(value= "SELECT * FROM product WHERE style_code = :style ORDER BY RAND() LIMIT 3", nativeQuery = true)
	List<Product> findRandImg3(@Param("style") Long style);

	
	@Query(value= "SELECT * FROM product WHERE style_code = :style ORDER BY RAND() LIMIT 10", nativeQuery = true)
	List<Product> findRandImg10(@Param("style") Long style);
	
	
	@Query("SELECT p FROM Product p JOIN ProductRank pr ON p.prodCode = pr.prodCode WHERE p.prodCategory = :category ORDER BY pr.cnt DESC LIMIT 30")
	List<Product> findTopByProdCategoryOrderByRankCntDesc(String category);
}
