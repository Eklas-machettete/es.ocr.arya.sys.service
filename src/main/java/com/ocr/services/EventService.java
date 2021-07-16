package com.ocr.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ocr.entities.Callback;
import com.ocr.entities.Invoice;
import com.ocr.model.Event;
import com.ocr.model.Invoices;
import com.ocr.model.Reponse;
import com.ocr.repositories.CallbackRepository;

@Service
public class EventService {
    @Autowired
    DigitalService digitalService;
    
    @Autowired
    CallbackRepository callbackRepository;
    
    @Async
	public ResponseEntity<Reponse> processFiles(Event event) {
		Reponse resp = new Reponse();
    	Invoice invoice = new Invoice();
    	Invoices invoices = new Invoices();
        RestTemplate restTemplate = new RestTemplate();
        //System.out.println(event.getBody()+" ------------------ "+event.getSubject());
    	Callback callback = callbackRepository.findByfileName(event.getSubject()).get(0);
    	
    	if(event.getBody().equals("SUCCESS"))
        	invoice = digitalService.getFilesProcessed(event.getSubject());
    	else
    		invoice.setFileName(event.getSubject());
		resp.setRegistros_procesados(invoice);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ArrayList<Invoice> array_invoices = new ArrayList<>();
        array_invoices.add(invoice);
        invoices.setOwner(callback.getOwner());
        invoices.setInvoices(array_invoices);
        HttpEntity<Invoices> request = new HttpEntity<Invoices>(invoices, headers); 
        String resultAsJsonStr = restTemplate.postForObject(callback.getCallbackUrl(), request, String.class);
        callbackRepository.delete(callback);
        
        return new ResponseEntity<Reponse>(resp, HttpStatus.OK);
		
	}


}
