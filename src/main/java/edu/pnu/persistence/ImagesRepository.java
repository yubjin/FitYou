package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Images;

public interface ImagesRepository extends JpaRepository<Images, Integer> {

}
