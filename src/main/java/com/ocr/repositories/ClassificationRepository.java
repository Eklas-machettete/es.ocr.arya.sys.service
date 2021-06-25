package com.ocr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ocr.entities.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, String> {

	List<Classification> findByclassification(String classification);
	
}
