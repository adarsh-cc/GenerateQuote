package com.camunda.academy.springrest.entity;

public class QuotationDetails {
	
	private String quoteId;
	
	public QuotationDetails() {}

	public QuotationDetails(String quoteId) {
		this.quoteId = quoteId;
	}

	public String getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}

	@Override
	public String toString() {
		return "QuotationDetails [quoteId=" + quoteId + "]";
	};
	
	

}
