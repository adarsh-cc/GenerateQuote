package com.camunda.academy.springrest.CamundaServices;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.camunda.academy.springrest.entity.Customer;
import com.camunda.academy.springrest.entity.Response;

import io.camunda.zeebe.client.api.worker.JobWorker;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Service
public class CamundaServiceImpl implements CamundaService {

	@Override
	public String home() {
		// TODO Auto-generated method stub
		return "Welcome to camunda service using spring boot";
	}
	
//	public String chargeCreditCard(final String reference,
//            final Integer amount,
//            final String cardNumber,
//            final String cardExpiryDate,
//            final String cardCVC) {
//
//	System.out.println("Starting Transaction: " + reference);
//	System.out.println("Card Number: " + cardNumber);
//	System.out.println("Card Expiry Date: " + cardExpiryDate);
//	System.out.println("Card CVC: " + cardCVC);
//	System.out.println("Amount: " + amount);
//	
//	final String confirmation = String.valueOf(System.currentTimeMillis());
//	System.out.println("Successful Transaction: " + confirmation);
//	return confirmation;
//
//	}
	
	public String returnResponse(String quotationId, Integer riskScore, Integer premium) {
		Response obj=new Response(quotationId,riskScore,premium);
		try {
			//write object to the file
			FileOutputStream fos = new FileOutputStream("mybean.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		

		return "Success";
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer obj=customer;
		return obj;
	}

}
