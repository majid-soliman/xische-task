package com.java.currency_Exchange.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface Discounts {

	public double calculate(double price);
	
}
