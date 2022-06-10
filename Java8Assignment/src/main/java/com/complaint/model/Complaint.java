package com.complaint.model;

import java.time.LocalDate;

public class Complaint {

	private int complaintID;

	private LocalDate dateReceived;

	private String product;

	private String subProduct;

	private String issue;

	private String subIssue;

	private String company;

	private String state;

	private String zipCode;

	private String submittedVia;

	private LocalDate dateClosed;

	private String companyResponse;

	private boolean timelyResponse;

	private boolean consumerDispute;

	public Complaint() {

	}

	public Complaint(int complaintID, LocalDate dateReceived, String product, String subProduct, String issue,
			String subIssue, String company, String state, String zipCode, String submittedVia, LocalDate dateClosed,
			String companyResponse, boolean timelyResponse, boolean consumerDispute) {
		super();
		this.complaintID = complaintID;
		this.dateReceived = dateReceived;
		this.product = product;
		this.subProduct = subProduct;
		this.issue = issue;
		this.subIssue = subIssue;
		this.company = company;
		this.state = state;
		this.zipCode = zipCode;
		this.submittedVia = submittedVia;
		this.dateClosed = dateClosed;
		this.companyResponse = companyResponse;
		this.timelyResponse = timelyResponse;
		this.consumerDispute = consumerDispute;
	}

	public int getComplaintID() {
		return complaintID;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	public LocalDate getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getSubProduct() {
		return subProduct;
	}

	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getSubIssue() {
		return subIssue;
	}

	public void setSubIssue(String subIssue) {
		this.subIssue = subIssue;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSubmittedVia() {
		return submittedVia;
	}

	public void setSubmittedVia(String submittedVia) {
		this.submittedVia = submittedVia;
	}

	public LocalDate getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(LocalDate dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getCompanyResponse() {
		return companyResponse;
	}

	public void setCompanyResponse(String companyResponse) {
		this.companyResponse = companyResponse;
	}

	public boolean isTimelyResponse() {
		return timelyResponse;
	}

	public void setTimelyResponse(boolean timelyResponse) {
		this.timelyResponse = timelyResponse;
	}

	public boolean isConsumerDispute() {
		return consumerDispute;
	}

	public void setConsumerDispute(boolean consumerDispute) {
		this.consumerDispute = consumerDispute;
	}

	@Override
	public String toString() {
		return "Complaint [complaintID=" + complaintID + ", dateReceived=" + dateReceived + ", product=" + product
				+ ", subProduct=" + subProduct + ", issue=" + issue + ", subIssue=" + subIssue + ", company=" + company
				+ ", state=" + state + ", zipCode=" + zipCode + ", submittedVia=" + submittedVia + ", dateClosed="
				+ dateClosed + ", companyResponse=" + companyResponse + ", timelyResponse=" + timelyResponse
				+ ", consumerDispute=" + consumerDispute + "]";
	}

}
