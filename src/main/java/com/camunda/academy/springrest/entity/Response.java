package com.camunda.academy.springrest.entity;

import java.io.Serializable;

public class Response implements Serializable{
	
	private String status;
	private String quotationId;
	private Integer riskScore;
	private Integer premium;
	
	public Response() {}

	public Response( String quotationId, Integer riskScore, Integer premium) {
		this.status = "success";
		this.quotationId = quotationId;
		this.riskScore = riskScore;
		this.premium = premium;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public Integer getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(Integer riskScore) {
		this.riskScore = riskScore;
	}

	public Integer getPremium() {
		return premium;
	}

	public void setPremium(Integer premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", quotationId=" + quotationId + ", riskScore=" + riskScore + ", premium="
				+ premium + "]";
	};
	
	

}
