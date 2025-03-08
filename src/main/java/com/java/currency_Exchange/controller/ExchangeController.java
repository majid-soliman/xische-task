package com.java.currency_Exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.java.currency_Exchange.Ent.InvoiceHeaderEnt;
import com.java.currency_Exchange.service.ExchangeService;
import com.java.currency_Exchange.service.InvoiceService;

@RestController
@RequestMapping("/exchangeApi")
@CrossOrigin("*")
public class ExchangeController {

	@Autowired
	ExchangeService service;
	
	@Autowired
	InvoiceService invService;
	
	@PostMapping("/createInvoice")
	public Double getCurrency(@RequestBody Map<String,Object> reqMap,
	@RequestHeader("API-KEY") String header) throws JsonMappingException, JsonProcessingException {
	reqMap.put("api-key", header);	
	return service.calculate(reqMap);
	}
	
	//for testing security Authentication 
	@GetMapping("/getName")
	public String getName() {
		return "Majid Soliman";
	}
	
	
	@PostMapping("/getInvoice")
	public InvoiceHeaderEnt getInvoice(@RequestBody Map<String, Object> map) {
		return invService.getInvoiceDetails(map);
	}
	
	//https://github.com/majid-soliman/xische-task.git
	
	
	
}
