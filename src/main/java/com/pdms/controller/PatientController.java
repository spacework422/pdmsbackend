package com.pdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdms.model.Patient;
import com.pdms.repository.PatientRepository;
import com.pdms.exception.ResourceNotFoundException; 
  
@RestController
@RequestMapping("/patientcontroller")
@CrossOrigin
public class PatientController {
	
	@Autowired
	private PatientRepository prepo;
	
	//Get - 
	//http://localhost:7075/pdms/patientcontroller/getpatient
	@GetMapping("/getpatient")
	public List<Patient> getAllProducts() {
		return prepo.findAll(); 
	} 
	
	//POST - 
	//http://localhost:7075/pdms/patientcontroller/patientregister
	@PostMapping("/patientregister")
    public Patient saveProduct(@Validated @RequestBody Patient patient) {
     return prepo.save(patient);
                    
	}
	
	//Get By ID - 
	//http://localhost:7075/pdms/patientcontroller/getbyid/{id}
	@GetMapping("/getbyid/{id}")
    public ResponseEntity<Patient> getProductById(@PathVariable(value="id") Integer pId)
    		throws ResourceNotFoundException
    		{
		      Patient patient =prepo.findById(pId).  //findById()  method is predefined in jpa in build
    			         orElseThrow(() -> new ResourceNotFoundException
    			          ("patient  Not Found for this Id: "+ String.valueOf(pId)));
    	             
    	             return ResponseEntity.ok().body(patient);     
    		}
	
	//Post verify user id
	//http://localhost:7075/pdms/patientcontroller/userlogin
	   @PostMapping("/userlogin")
	    public Boolean loginUser(@Validated @RequestBody Patient patient) 
	    {
	        Boolean a=false;;
	        String name=patient.getName();
	        String password=patient.getPassword();
	        Patient b = prepo.findByName(name);
	        if(b==null) {
	        	return a;
	        }
	        if(name.equals(b.getName()) && password.equals(b.getPassword()))
	                {
	            a=true;
	           
	                }
	        return a;
	    }

} 



