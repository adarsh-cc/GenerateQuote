package com.camunda.academy.springrest.CamundaServices;

import com.camunda.academy.springrest.entity.Customer;

public interface CamundaService {
	
	public String home();
	
	public Customer addCustomer(Customer customer);

}
