package com.java.currency_Exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class IntegrationService {

	private WebClient webClient;
	
	@Autowired
	public IntegrationService() {
		this.webClient = WebClient.builder().
		baseUrl("https://v6.exchangerate-api.com").build();
    }
	
public Mono<String> getName(String apiKey,String toCurrency){
	  return webClient.get().uri("/v6/"+apiKey+"/latest/"+toCurrency).retrieve().bodyToMono(String.class);
	}
}
