package com.camunda.academy.springrest.CamundaServices;

import java.util.HashMap;
import java.util.Map;

//import com.caminda.academy.service.CreditCardService;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.client.api.worker.JobHandler;

public class CreditCardServiceHandler implements JobHandler{
	
	CamundaServiceImpl creditCardService = new CamundaServiceImpl();

    @Override
    public void handle(JobClient client, ActivatedJob job) throws Exception {
    	final Map<String, Object> inputVariables = job.getVariablesAsMap();
        
    	final String quoteId=(String) inputVariables.get("quoteId");
    	final Integer premium= (Integer) inputVariables.get("ReturnPremium");
    	final Integer riskScore=(Integer) inputVariables.get("ReturnRiskScore");

        //final String confirmation = creditCardService.chargeCreditCard(reference, amount, cardNumber, cardExpiry, cardCVC);
        
    	creditCardService.returnResponse(quoteId,riskScore,premium);
        
        System.out.println("Camunda quotation Id:"+quoteId);
        System.out.println("Camunda Premium:"+premium);
        System.out.println("Camunda Risk Score:"+riskScore);
        
//        final Map<String, Object> outputVariables = new HashMap<String, Object>();
//        outputVariables.put("confirmation", confirmation);

        client.newCompleteCommand(job.getKey()).send().join();
    }

}
