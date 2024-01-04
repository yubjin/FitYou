package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findSeqByName(String name);
}
