package com.java.currency_Exchange.Ent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "invoice_header")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceHeaderEnt implements Serializable {

	private static final long serialVersionUID = -4439114469417994311L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int userId;
	@Column(name= "created_on")
	private String createdOn;
	
	@Column(name = "invoice_id")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="invoice_id",  referencedColumnName = "id")
	List<InvoiceDetailsEnt> details = new ArrayList<InvoiceDetailsEnt>();

	
}
