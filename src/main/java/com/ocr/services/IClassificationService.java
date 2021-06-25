package com.ocr.services;

import java.util.Optional;

import com.ocr.entities.Classification;

public interface IClassificationService {

	Optional<Classification> findByclassification(String classification);
}
