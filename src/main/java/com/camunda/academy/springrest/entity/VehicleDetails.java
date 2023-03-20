package com.camunda.academy.springrest.entity;

public class VehicleDetails {
	
	private long estimatedAnnualMilage;
	private long registrationYear;
	private int carAge;
	
	public VehicleDetails() {}

	public VehicleDetails(long estimatedAnnualMilage, long registrationYear) {
		this.estimatedAnnualMilage = estimatedAnnualMilage;
		this.registrationYear = registrationYear;
	}

	public long getEstimatedAnnualMilage() {
		return estimatedAnnualMilage;
	}

	public void setEstimatedAnnualMilage(long estimatedAnnualMilage) {
		this.estimatedAnnualMilage = estimatedAnnualMilage;
	}

	public long getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(long registrationYear) {
		this.registrationYear = registrationYear;
	}

	public int getCarAge() {
		return carAge;
	}

	public void setCarAge(int carAge) {
		this.carAge = carAge;
	}

	@Override
	public String toString() {
		return "VehicleDetails [estimatedAnnualMilage=" + estimatedAnnualMilage + ", registrationYear="
				+ registrationYear + ", carAge=" + carAge + "]";
	}

	

}
