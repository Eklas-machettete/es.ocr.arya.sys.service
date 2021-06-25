package com.ocr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Callback {


 	@Id
    private String uid;
    private String callbackUrl;
    private String owner;
    private String fileName;
    
    public Callback() {
    }

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}



}
