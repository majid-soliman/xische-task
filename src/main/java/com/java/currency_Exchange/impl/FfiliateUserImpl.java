package com.java.currency_Exchange.impl;

import org.springframework.stereotype.Component;

import com.java.currency_Exchange.interfaces.Discounts;

@Component("fifiliate")
public class FfiliateUserImpl implements Discounts{

	@Override
	public double calculate(double price) {
     return price*10/100 ;
	}
}
