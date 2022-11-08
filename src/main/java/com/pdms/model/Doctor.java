package com.pdms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Doctor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Doctor {
	
	@Id
	@GeneratedValue
	private int doctorId;
	
	    private String name;
	    private String hospital;
	    private String specialization;
	    private String experiance;
	    private String location;
	    private String username;
	    private String password;
	    
	  	    
} 

