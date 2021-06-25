package com.ocr.services;

import java.util.Optional;

import com.ocr.entities.Callback;

public interface ICallbackService {

	Optional<Callback> findByfileName(String fileName);
}
