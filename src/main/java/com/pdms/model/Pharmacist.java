package com.pdms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Pharmacist")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pharmacist {
	
	@Id
	@GeneratedValue
	private int pharmaId;
	
	    private String name;
	    private String phone;
	    private String location;
	    private String username;
	    private String password;
	   
	    
} 

