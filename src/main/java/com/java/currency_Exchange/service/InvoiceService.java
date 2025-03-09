package com.java.currency_Exchange.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.currency_Exchange.Ent.InvoiceDetailsEnt;
import com.java.currency_Exchange.Ent.InvoiceHeaderEnt;
import com.java.currency_Exchange.dao.*;
@Service
public class InvoiceService {

	@Autowired
	InvoicesDAO dao;
	
	public Map<String, Object> createInvoice(JSONObject json) throws JsonMappingException, JsonProcessingException {
		JSONObject  headerJSON = (JSONObject) json.get("headerMap");
		JSONObject  detailsJSON = (JSONObject) json.get("detailsMap");
		ObjectMapper mapper = new ObjectMapper();
		
		InvoiceHeaderEnt header = mapper.readValue(headerJSON.toString(), InvoiceHeaderEnt.class);
		InvoiceDetailsEnt details = mapper.readValue(detailsJSON.toString(), InvoiceDetailsEnt.class);
	    
	  return  dao.createInvoice(header, details);
	}
	
	public Map<String, Object> getInvoiceDetails(Map<String, Object> reqMap) {
		return dao.getInvoiceDetails((Integer)reqMap.get("invoiceId"));
	}
	
	
	
	
	
}
