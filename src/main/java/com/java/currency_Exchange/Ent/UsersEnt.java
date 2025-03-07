package com.java.currency_Exchange.Ent;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEnt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private double discount;
    private String name;
    private String type;
    @Column(name = "created_on")
    private Date createdOn;
  
    
    
}
