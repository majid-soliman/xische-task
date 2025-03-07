package com.java.currency_Exchange.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.currency_Exchange.Ent.UsersEnt;
import com.java.currency_Exchange.interfaces.UsersRepo;

@Component
public class UsersDAO {

	@Autowired
	UsersRepo repo;
	
	public UsersEnt getUserDetails(int userId) {
		return repo.findById(userId).get(); 
	}
	
}
