package com.camunda.academy.springrest.entity;

import java.util.Date;
import java.time.LocalDate;  
import java.time.Period;  

public class CustomerDetails {
	
	private String firstName;
	private String lastName;
	private String dob;
	private int age;
	private String gender;
	private long phone;
	private String emailId;
	private String licenseNo;
	private Address address;
	private QuotationDetails quotationDetails;
	
	public CustomerDetails() {}

	public CustomerDetails(String firstName, String lastName, String dob, String gender, long phone, String emailId,
			String licenseNo, Address address, QuotationDetails quotationDetails) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.emailId = emailId;
		this.licenseNo = licenseNo;
		this.address = address;
		this.quotationDetails = quotationDetails;
		//this.age=Period.between(LocalDate.parse(dob), LocalDate.now()).getYears();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public QuotationDetails getQuotationDetails() {
		return quotationDetails;
	}

	public void setQuotationDetails(QuotationDetails quotationDetails) {
		this.quotationDetails = quotationDetails;
	}
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "CustomerDetails [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", age=" + age
				+ ", gender=" + gender + ", phone=" + phone + ", emailId=" + emailId + ", licenseNo=" + licenseNo
				+ ", address=" + address + ", quotationDetails=" + quotationDetails + "]";
	}
	

	

	

}
