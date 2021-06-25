package com.ocr.model;

import java.util.ArrayList;
import java.util.List;

public class Files {

	private List<File> files;
    private String classification;
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(ArrayList<File> files) {
		this.files = files;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
}
