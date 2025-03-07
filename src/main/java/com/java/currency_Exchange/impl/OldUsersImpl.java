package com.java.currency_Exchange.impl;

import com.java.currency_Exchange.interfaces.Discounts;

public class OldUsersImpl implements Discounts {

	@Override
	public double calculate(double price) {
     return price*5/100 ;
	}

}
