package com.ocr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.entities.Callback;
import com.ocr.repositories.CallbackRepository;


@Service
public class CallbackService implements ICallbackService {

    @Autowired
    private CallbackRepository callbackRepository;

	@Override
	public Optional<Callback> findByfileName(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
