package com.java.currency_Exchange.impl;

import com.java.currency_Exchange.interfaces.Discounts;

public class EmployeeDiscount implements Discounts {

	@Override
	public double calculate(double price) {
	return price*30/100 ;
	}

}
