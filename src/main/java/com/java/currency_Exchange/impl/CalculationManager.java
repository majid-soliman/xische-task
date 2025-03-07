package com.java.currency_Exchange.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.java.currency_Exchange.Ent.UsersEnt;
import com.java.currency_Exchange.interfaces.Discounts;
import com.java.currency_Exchange.interfaces.UsersRepo;

@Component
public class CalculationManager {

	@Autowired
	UsersRepo repo;
	
	
	@Autowired
	@Qualifier("employee")
	Discounts employeeDiscount;
	
	@Autowired
	@Qualifier("oldUser")
	Discounts oldUserDiscount;
	
	@Autowired
	@Qualifier("fifiliate")
	Discounts fifiliateDiscount;
	
	public double manageCalculation(double amount, int userId) {
		UsersEnt u = repo.findById(userId).get();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
	    double result = 0;
		
		if(u.getCreatedOn().before(calendar.getTime())) {
	    	result = oldUserDiscount.calculate(amount);
	    }
		
		if(u.getType().equals("employee")) {
			result = employeeDiscount.calculate(amount);
		}
		
		if(u.getType().equals("affiliate")) {
			result = fifiliateDiscount.calculate(amount);
		}
		
	    return result; 
	}
	
	
}
