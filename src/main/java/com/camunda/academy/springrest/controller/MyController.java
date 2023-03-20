package com.camunda.academy.springrest.controller;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.camunda.academy.springrest.CamundaServices;
import com.camunda.academy.springrest.CamundaServices.CamundaService;
import com.camunda.academy.springrest.CamundaServices.CreditCardServiceHandler;
import com.camunda.academy.springrest.entity.Customer;
import com.camunda.academy.springrest.entity.CustomerDetails;
import com.camunda.academy.springrest.entity.Drivers;
import com.camunda.academy.springrest.entity.Response;
import com.camunda.academy.springrest.entity.VehicleDetails;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.worker.JobWorker;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProvider;
import io.camunda.zeebe.client.impl.oauth.OAuthCredentialsProviderBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@RestController
public class MyController {

	private static final String ZEEBE_ADDRESS = "f476dc01-3840-4154-94f9-e4ffa0d8124e.jfk-1.zeebe.camunda.io:443";
	private static final String ZEEBE_CLIENT_ID = "vXrTTOCvE-6suLqKCY1peY1vnWwkdWI9";
	private static final String ZEEBE_CLIENT_SECRET = ".jO_C_CDhMrENhs_8OOHBiFGWRaHzkPrHXzqE.lFGRIUzoJ6geMDe_8g0LkGdlc9";
	private static final String ZEEBE_AUTHORIZATION_SERVER_URL = "https://login.cloud.camunda.io/oauth/token";
	private static final String ZEEBE_TOKEN_AUDIENCE = "zeebe.camunda.io";

	@Autowired
	private CamundaService camundaService;

	public void camundaConnection(Customer customer) {
		final OAuthCredentialsProvider credentialsProvider = new OAuthCredentialsProviderBuilder()
				.authorizationServerUrl(ZEEBE_AUTHORIZATION_SERVER_URL).audience(ZEEBE_TOKEN_AUDIENCE)
				.clientId(ZEEBE_CLIENT_ID).clientSecret(ZEEBE_CLIENT_SECRET).build();

		try (final ZeebeClient client = ZeebeClient.newClientBuilder().gatewayAddress(ZEEBE_ADDRESS)
				.credentialsProvider(credentialsProvider).build()) {
			// final Map<String, Object> variables = new HashMap<String, Object>();
//    		variables.put("reference", "C8_12345");
//    		variables.put("amount", Double.valueOf(100.00));
//    		variables.put("cardNumber", "1234567812345678");
//    		variables.put("cardExpiry", "12/2023");
//    		variables.put("cardCVC", "123");

			client.newCreateInstanceCommand().bpmnProcessId("Process_AutoQuote").latestVersion().variables(customer)
					.send().join();

			final JobWorker creditCardWorker = client.newWorker().jobType("chargeCreditCard")
					.handler(new CreditCardServiceHandler()).timeout(Duration.ofSeconds(10).toMillis()).open();
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GetMapping("/home")
	public ResponseEntity<String> home() {
		System.out.println("Hello");
		String str = camundaService.home();
		if (str.length() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(str);
	}

	@PostMapping("/customer")
	public ResponseEntity<Response> addCustomer(@RequestBody Customer customer) {
		Response result=new Response();
		try {
			VehicleDetails vehicleDetails=customer.getVehicleDetails();
			//getting current year
	        int currentYear=LocalDate.now().getYear();
	        
	        //calculating car age
	        int carAge=(int)(currentYear - vehicleDetails.getRegistrationYear());
	        
	        vehicleDetails.setCarAge(carAge);
	        customer.setVehicleDetails(vehicleDetails);
	        //getting no of drivers
	        int noOfDrivers=customer.getDrivers().length;
	        Drivers drivers[]=new Drivers[customer.getDrivers().length];
	        for(int i=0;i<customer.getDrivers().length;i++) {
	        	Drivers tempDriver=customer.getDrivers()[i];
	        	int driverAge=Period.between(LocalDate.parse(tempDriver.getDob()), LocalDate.now()).getYears();  
	        	tempDriver.setAge(driverAge);
	        	drivers[i]=tempDriver;
	        	//System.out.println(": "+driverAge);
	        	System.out.println("Temp Driver: "+drivers[i]);
	        }
	        
	        customer.setDrivers(drivers);
	        customer.setNoOfDrivers(noOfDrivers);
	        System.out.println("No of Drivers: "+drivers.length);
			System.out.println("New Customer: "+ customer);
			camundaConnection(customer);
			//fetchCamundaVariables();
			//reading object from file
			try {
				FileInputStream fis = new FileInputStream("mybean.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				 result = (Response) ois.readObject();
				System.out.println("Returned object: "+result);
				ois.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			return ResponseEntity.status(HttpStatus.FOUND).body(result);
		}catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}

}
