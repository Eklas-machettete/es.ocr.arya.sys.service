package com.ocr.services;

import java.util.Optional;

import com.ocr.entities.Invoice;

public interface IInvoiceService {

	Optional<Invoice> findByfileName(String fileName);
}
