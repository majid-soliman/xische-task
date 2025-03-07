package com.java.currency_Exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.currency_Exchange.impl.CalculationManager;

import org.json.JSONObject;
import java.util.Map;
@Service
public class ExchangeService {

	@Autowired
	IntegrationService intService;
	
	@Autowired
	CalculationManager manager;
	
	public double calculate(Map<String,Object> reqMap) {
     double result = Double.parseDouble(reqMap.get("amount").toString()) 
     * getCurrencyPrice(reqMap.get("currency").toString(),reqMap.get("toCurrency").toString(),
     reqMap.get("api-key").toString());
     double discount = manager.manageCalculation(result, (Integer) reqMap.get("userId")); 
     return result - discount; 
	}
	
	public double getCurrencyPrice(String currency,String toCurrency,String apiKey) {
	   String intResult = intService.getName(apiKey,toCurrency).block();
		 JSONObject json = new JSONObject(intResult);
		 JSONObject price = (JSONObject) json.get("conversion_rates"); 
		 return price.getDouble(currency);
	}
	
}
