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
import com.java.currency_Exchange.service.ExchangeService;

@RestController
@RequestMapping("/exchangeApi")
@CrossOrigin("*")
public class ExchangeController {

	@Autowired
	ExchangeService service;
	
	@PostMapping("/getCurrency")
	public Double getCurrency(@RequestBody Map<String,Object> reqMap,
	@RequestHeader("API-KEY") String header) {
	reqMap.put("api-key", header);	
	return service.calculate(reqMap);
	}
	
	//https://github.com/majid-soliman/xische-task.git
	
	
}
