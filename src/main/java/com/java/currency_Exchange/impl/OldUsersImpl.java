package com.java.currency_Exchange.impl;

import org.springframework.stereotype.Component;

import com.java.currency_Exchange.interfaces.Discounts;

@Component("oldUser")
public class OldUsersImpl implements Discounts {

	@Override
	public double calculate(double price) {
     return price*5/100 ;
	}

}
