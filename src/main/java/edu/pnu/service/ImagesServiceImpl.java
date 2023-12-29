package edu.pnu.service;

import org.springframework.stereotype.Service;

import edu.pnu.persistence.ImagesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImagesServiceImpl {
	
	private final ImagesRepository imRepo;

}
