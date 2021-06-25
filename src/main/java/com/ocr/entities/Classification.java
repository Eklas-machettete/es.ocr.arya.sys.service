package com.ocr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classification {


 	@Id
    private String classification;
    private String path;
    
    public Classification() {
    }

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public void setClassification(String calssification) {
		this.classification = calssification;
	}
	public String getClassification() {
		return classification;
	}


}
