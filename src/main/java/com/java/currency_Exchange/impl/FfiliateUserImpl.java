package com.java.currency_Exchange.impl;

import com.java.currency_Exchange.interfaces.Discounts;

public class FfiliateUserImpl implements Discounts{

	@Override
	public double calculate(double price) {
     return price*10/100 ;
	}
}
