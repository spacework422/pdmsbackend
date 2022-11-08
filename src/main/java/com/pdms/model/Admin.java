package com.pdms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Admin")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Admin {
	
	@Id
	@GeneratedValue
	private int adminId;
	
	    private String username;
	    private String password;
	    private String name;
	    private String address;
	    private String phoneno;
	   
	    
} 

