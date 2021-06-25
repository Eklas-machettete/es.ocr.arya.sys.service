package com.ocr.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ocr.entities.Classification;
import com.ocr.entities.Invoice;
import com.ocr.model.File;
import com.ocr.model.Files;
import com.ocr.repositories.ClassificationRepository;
import com.ocr.repositories.InvoiceRepository;


@Service
public class DigitalService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DigitalService.class);

	@Value("${drive.url}")
	private String url;
    
    @Autowired
    ClassificationRepository classificationRepository;

    @Autowired
    InvoiceRepository invoiceRepository;
    
    public String pushHotfolder(Files files, String uid) {

        RestTemplate restTemplate = new RestTemplate();
        String resultAsJsonStr  = "";
        HttpHeaders headers = new HttpHeaders();
        List<Classification> classifications = new ArrayList<Classification>();
        
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url_f = url;
        classifications = classificationRepository.findByclassification(files.getClassification());
        
        System.out.println("URL: "+url_f);
        
        for(File file:files.getFiles())
        {
        	
        	
        	MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
        	ByteArrayResource resource = new ByteArrayResource(Base64.getDecoder().decode(file.getEncode())) {
        	    @Override
        	    public String getFilename() {
        	        return uid+"-"+file.getName();
        	    }
        	};
        	data.add("file", resource);
        	data.add("mime", "application/pdf");
        	data.add("parent", classifications.get(0).getPath());

        	HttpHeaders requestHeaders = new HttpHeaders();
        	requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        	HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(data, requestHeaders);


        	resultAsJsonStr = restTemplate.postForObject(url_f, requestEntity, String.class);

            System.out.println(resultAsJsonStr);
            //resp.setResultados_request(rl);
        }
		return resultAsJsonStr;
    }
        
    public Invoice getFilesProcessed(String fileName) {
    	Invoice invoice = new Invoice();
    	invoice = invoiceRepository.findByfileName(fileName).get(0);
		return invoice;
    }
            
}
