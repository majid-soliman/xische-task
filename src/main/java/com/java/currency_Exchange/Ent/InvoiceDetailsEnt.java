package com.java.currency_Exchange.Ent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailsEnt implements Serializable {

	   private static final long serialVersionUID = -4439114469417994311L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String currency;
	@Column(name = "chnageTo")
	private String toCurrency;
	private double amount;
	@Column (name = "result_amount")
	private double resultAmount;
	
	
}
