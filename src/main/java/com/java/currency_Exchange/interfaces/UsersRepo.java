package com.java.currency_Exchange.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.currency_Exchange.Ent.UsersEnt;
public interface UsersRepo extends JpaRepository<UsersEnt,Integer> {

}
