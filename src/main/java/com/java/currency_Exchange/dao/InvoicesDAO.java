package com.java.currency_Exchange.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.java.currency_Exchange.interfaces.InvoiceDetailsRepo;
import com.java.currency_Exchange.interfaces.InvoiceHeaderRepo;

import jakarta.transaction.Transactional;

import com.java.currency_Exchange.Ent.*;
import com.java.currency_Exchange.exceptions.InvoiceNotfoundException;

import java.util.HashMap;
import java.util.Map;

@Component
public class InvoicesDAO {

	@Autowired
	InvoiceHeaderRepo headerRepo;
	
	@Autowired
	InvoiceDetailsRepo DetailsrRepo;
	
	@Transactional
	public Map<String, Object> createInvoice(InvoiceHeaderEnt header, InvoiceDetailsEnt details) {
		header.getDetails().add(details);
		Map<String, Object> resMap = new HashMap<String, Object>();
		try {
			InvoiceHeaderEnt invoiceDetails = headerRepo.save(header);
			resMap.put("invoiceDetails", invoiceDetails);
        }catch(Exception exception){
        	exception.printStackTrace();
        	resMap.put("Error", exception.getMessage());
        }
		
		return resMap;
	}
	
	//@Cacheable(value="InvoiceHeaderEnt", key="#invoiceId")
	public Map<String, Object> getInvoiceDetails(int invoiceId) {
	Map<String, Object> resMap = new HashMap<String, Object>();
	InvoiceHeaderEnt header = null;
	try {
		header = headerRepo.findById(invoiceId).get();
		resMap.put("invoiceDetails", header);
	
	}catch(Exception exception) {
	exception.printStackTrace();
	resMap.put("Error", exception.getMessage());
	}
    System.out.println(header.getUserId());	    
	return resMap;
	}
	
}
