package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	List<Product> findByStyle(Long style);
	List<String> findImageUrlByStyle(Long style);
	
	@Query(value= "SELECT * FROM product ORDER BY RAND() LIMIT 5", nativeQuery = true)
	List<Product> findRandImg5(Long style);
	
	@Query(value= "SELECT * FROM product ORDER BY RAND() LIMIT 3", nativeQuery = true)
	List<Product> findRandImg3(Long style);
	
	@Query(value= "SELECT * FROM product ORDER BY RAND() LIMIT 10", nativeQuery = true)
	List<Product> findRandImg10(Long style);
}
