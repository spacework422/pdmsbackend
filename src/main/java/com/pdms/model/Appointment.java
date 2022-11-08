package com.pdms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Appointment")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Appointment {
	
	@Id
	@GeneratedValue
	private int id;
	
	    private String patientname;
	    private String patientemail;
	    private String patientselectedstream;
	    private String patientselectedhospital;
	    private String patientselecteddoctorname;
	    private String patientsymptoms;
	    private String doctorprescption;
	    private Boolean doctorverified = false;
	   
	    
} 

