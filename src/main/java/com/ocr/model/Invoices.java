package com.ocr.model;

import java.util.ArrayList;

import com.ocr.entities.Invoice;

public class Invoices {

	private ArrayList<Invoice> invoices;
	private String owner;
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}
}
