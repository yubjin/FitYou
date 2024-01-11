package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.ProductRank;

public interface ProductRankRepository extends JpaRepository<ProductRank, String> {
	
}
