package com.camunda.academy.springrest.entity;

import java.util.Arrays;

public class Customer {
	
	private CustomerDetails customerDetails;
	private VehicleDetails vehicleDetails;
	private Deductibles deductibles;
	private Drivers[] drivers;
	private int noOfDrivers;
	
	public Customer() {}

	public Customer(CustomerDetails customerDetails, VehicleDetails vehicleDetails, Deductibles deductibles,
			Drivers[] drivers) {
		this.customerDetails = customerDetails;
		this.vehicleDetails = vehicleDetails;
		this.deductibles = deductibles;
		this.drivers = drivers;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public VehicleDetails getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(VehicleDetails vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}

	public Deductibles getDeductibles() {
		return deductibles;
	}

	public void setDeductibles(Deductibles deductibles) {
		this.deductibles = deductibles;
	}

	public Drivers[] getDrivers() {
		return drivers;
	}

	public void setDrivers(Drivers[] drivers) {
		this.drivers = drivers;
	}
	
	

	public int getNoOfDrivers() {
		return noOfDrivers;
	}

	public void setNoOfDrivers(int noOfDrivers) {
		this.noOfDrivers = noOfDrivers;
	}

	@Override
	public String toString() {
		return "Customer [customerDetails=" + customerDetails + ", vehicleDetails=" + vehicleDetails + ", deductibles="
				+ deductibles + ", drivers=" + Arrays.toString(drivers) + ", noOfDrivers=" + noOfDrivers + "]";
	}
	
	

}
