package com.java.currency_Exchange.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.currency_Exchange.Ent.InvoiceDetailsEnt;

public interface InvoiceDetailsRepo extends JpaRepository<InvoiceDetailsEnt, Integer> {

}
