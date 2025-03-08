package com.java.currency_Exchange.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.java.currency_Exchange.interfaces.InvoiceDetailsRepo;
import com.java.currency_Exchange.interfaces.InvoiceHeaderRepo;

import jakarta.transaction.Transactional;

import com.java.currency_Exchange.Ent.*;
import com.java.currency_Exchange.exceptions.InvoiceNotfoundException;

import java.util.Map;

@Component
public class InvoicesDAO {

	@Autowired
	InvoiceHeaderRepo headerRepo;
	
	@Autowired
	InvoiceDetailsRepo DetailsrRepo;
	
	@Transactional
	public InvoiceHeaderEnt createInvoice(InvoiceHeaderEnt header, InvoiceDetailsEnt details) {
		header.getDetails().add(details);
	return headerRepo.save(header);
	}
	
	//@Cacheable(value="InvoiceHeaderEnt", key="#invoiceId")
	public InvoiceHeaderEnt getInvoiceDetails(int invoiceId) {
		return headerRepo.findById(invoiceId).orElseThrow(()->  new InvoiceNotfoundException("Invoice Not found!"));
	}
	
}
