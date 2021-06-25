package com.ocr.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Invoice {

	@Id
	private String transmitterName;
	private String fileName;
    private String transmitterAddress;
    private String transmitterCif;
    private String receptorName;
    private String receptorAddress;
    private String receptorCif;
    private String reference;
    private String providerNif;
    private String providerCountry;
    private String providerCode;
    private String invoiceNumber;
    private String invoiceType;
    private String invoiceDate;
    private String invoiceVigencyDate;
    private String invoiceContableDate;
    private String concept;
    private String description;
    private String units;
    private String imports;
    private String oprtationDescription;
    private String bruteTotal;
    private String base;
    private String iva;
    private String irpf;
    private String retentionType;
    private String retentionBase;
    private String retentionImports;
    private String surchargesPercentage;
    private String surchargesBase;
    private String surchargesImports;
    private String suppliers;
    private String paymentType;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTransmitterAddress() {
		return transmitterAddress;
	}
	public void setTransmitterAddress(String transmitterAddress) {
		this.transmitterAddress = transmitterAddress;
	}
	public String getTransmitterCif() {
		return transmitterCif;
	}
	public void setTransmitterCif(String transmitterCif) {
		this.transmitterCif = transmitterCif;
	}
	public String getReceptorName() {
		return receptorName;
	}
	public void setReceptorName(String receptorName) {
		this.receptorName = receptorName;
	}
	public String getReceptorAddress() {
		return receptorAddress;
	}
	public void setReceptorAddress(String receptorAddress) {
		this.receptorAddress = receptorAddress;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getProviderNif() {
		return providerNif;
	}
	public void setProviderNif(String providerNif) {
		this.providerNif = providerNif;
	}
	public String getReceptorCif() {
		return receptorCif;
	}
	public void setReceptorCif(String receptorCif) {
		this.receptorCif = receptorCif;
	}
	public String getProviderCountry() {
		return providerCountry;
	}
	public void setProviderCountry(String providerCountry) {
		this.providerCountry = providerCountry;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getProviderCode() {
		return providerCode;
	}
	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getInvoiceVigencyDate() {
		return invoiceVigencyDate;
	}
	public void setInvoiceVigencyDate(String invoiceVigencyDate) {
		this.invoiceVigencyDate = invoiceVigencyDate;
	}
	public String getInvoiceContableDate() {
		return invoiceContableDate;
	}
	public void setInvoiceContableDate(String invoiceContableDate) {
		this.invoiceContableDate = invoiceContableDate;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImports() {
		return imports;
	}
	public void setImports(String imports) {
		this.imports = imports;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getOprtationDescription() {
		return oprtationDescription;
	}
	public void setOprtationDescription(String oprtationDescription) {
		this.oprtationDescription = oprtationDescription;
	}
	public String getBruteTotal() {
		return bruteTotal;
	}
	public void setBruteTotal(String bruteTotal) {
		this.bruteTotal = bruteTotal;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getIva() {
		return iva;
	}
	public void setIva(String iva) {
		this.iva = iva;
	}
	public String getIrpf() {
		return irpf;
	}
	public void setIrpf(String irpf) {
		this.irpf = irpf;
	}
	public String getRetentionType() {
		return retentionType;
	}
	public void setRetentionType(String retentionType) {
		this.retentionType = retentionType;
	}
	public String getRetentionBase() {
		return retentionBase;
	}
	public void setRetentionBase(String retentionBase) {
		this.retentionBase = retentionBase;
	}
	public String getRetentionImports() {
		return retentionImports;
	}
	public void setRetentionImports(String retentionImports) {
		this.retentionImports = retentionImports;
	}
	public String getSurchargesPercentage() {
		return surchargesPercentage;
	}
	public void setSurchargesPercentage(String surchargesPercentage) {
		this.surchargesPercentage = surchargesPercentage;
	}
	public String getSurchargesBase() {
		return surchargesBase;
	}
	public void setSurchargesBase(String surchargesBase) {
		this.surchargesBase = surchargesBase;
	}
	public String getSurchargesImports() {
		return surchargesImports;
	}
	public void setSurchargesImports(String surchargesImports) {
		this.surchargesImports = surchargesImports;
	}
	public String getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(String suppliers) {
		this.suppliers = suppliers;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
    
    
}