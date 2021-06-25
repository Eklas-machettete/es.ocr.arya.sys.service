package com.ocr.controllers;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ocr.entities.Callback;
import com.ocr.entities.Invoice;
import com.ocr.model.Event;
import com.ocr.model.Files;
import com.ocr.model.Invoices;
import com.ocr.model.Reponse;
import com.ocr.repositories.CallbackRepository;
import com.ocr.services.DigitalService;


@Controller
public class OcrController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OcrController.class);

	private static final String NULL = null;
    
    @Autowired
    DigitalService digitalService;
    
    @Autowired
    CallbackRepository callbackRepository;


    @PostMapping(path = "/files", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Reponse> processFiles(@RequestBody Files files, @RequestParam(name = "callbackUrl", required = true) String callbackUrl, @RequestParam(name = "owner", required = true) String owner) throws InvalidKeyException, IOException, ParseException {
    	Reponse resp = new Reponse();
    	String id = UUID.randomUUID().toString().replace("-", "");
    	for(com.ocr.model.File file: files.getFiles())
    	{
        	Callback callback = new Callback();
        	callback.setUid(id);
        	callback.setCallbackUrl(callbackUrl);
        	callback.setFileName(id+"-"+file.getName());
        	callback.setOwner(owner);
        	callbackRepository.save(callback);
    	}
    	resp.setNombre(digitalService.pushHotfolder(files, id));
        return new ResponseEntity<Reponse>(resp, HttpStatus.OK);
    }
    

    @PostMapping(path = "/callback", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Reponse> processFiles(@RequestBody Event event) throws InvalidKeyException, IOException, ParseException {
    	Reponse resp = new Reponse();
    	Invoice invoice = new Invoice();
    	Invoices invoices = new Invoices();
        RestTemplate restTemplate = new RestTemplate();
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
    
    @PostMapping(value = "/drive", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<String> setFile(@RequestParam("file") MultipartFile file, @RequestParam(name = "mime") String mimeType, @RequestParam(name = "parent", required = false) String parent){
		
		return new ResponseEntity<String>("Complete", HttpStatus.OK);
	}
    
}
