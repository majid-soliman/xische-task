package com.java.currency_Exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.java.currency_Exchange.impl.CalculationManager;

import org.json.JSONObject;

import java.util.Date;
import java.util.Map;
@Service
public class ExchangeService {

	@Autowired
	IntegrationService intService;
	
	@Autowired
	CalculationManager manager;
	
	@Autowired
	InvoiceService invoiceService;
	
	public Map<String, Object> calculate(Map<String,Object> reqMap) throws JsonMappingException, JsonProcessingException {
     double result = Double.parseDouble(reqMap.get("amount").toString()) 
     * getCurrencyPrice(reqMap.get("currency").toString(),reqMap.get("toCurrency").toString(),
     reqMap.get("api-key").toString());
     double discount = manager.manageCalculation(result, (Integer) reqMap.get("userId")); 
     
     result = result - discount;
     
     Map<String, Object> headerMap = Map.of("createdOn",new Date(),"userId"
     ,(Integer) reqMap.get("userId"));
     
     Map<String,Object> detailsMap = Map.of("currency",reqMap.get("currency").toString()
    ,"toCurrency",reqMap.get("toCurrency").toString(),"amount",reqMap.get("amount")
    ,"resultAmount",result);
     
     JSONObject json = new JSONObject();
     json.put("headerMap", headerMap);
     json.put("detailsMap", detailsMap);
     
     return invoiceService.createInvoice(json);
     }
	
	public double getCurrencyPrice(String currency,String toCurrency,String apiKey) {
	   String intResult = intService.getName(apiKey,toCurrency).block();
		 JSONObject json = new JSONObject(intResult);
		 JSONObject price = (JSONObject) json.get("conversion_rates"); 
		 return price.getDouble(currency);
	}
	
	
}
