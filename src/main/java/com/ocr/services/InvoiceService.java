package com.ocr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocr.entities.Invoice;
import com.ocr.repositories.InvoiceRepository;


@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

	@Override
	public Optional<Invoice> findByfileName(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
