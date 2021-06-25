package com.ocr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.entities.Classification;
import com.ocr.repositories.ClassificationRepository;


@Service
public class ClassificationService implements IClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

	@Override
	public Optional<Classification> findByclassification(String classification) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
