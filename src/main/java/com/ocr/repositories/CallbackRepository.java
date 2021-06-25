package com.ocr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ocr.entities.Callback;

public interface CallbackRepository extends JpaRepository<Callback, String> {

	List<Callback> findByfileName(String fileName);
	
}
