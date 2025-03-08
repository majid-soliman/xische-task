package com.java.currency_Exchange.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.currency_Exchange.Ent.*;
public interface InvoiceHeaderRepo extends JpaRepository<InvoiceHeaderEnt, Integer> {

}
