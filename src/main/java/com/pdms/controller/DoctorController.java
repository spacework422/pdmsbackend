package com.pdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdms.model.Doctor;
import com.pdms.repository.DoctorRepository;
import com.pdms.exception.ResourceNotFoundException; 
 
  
@RestController
@RequestMapping("/doctorcontroller")
@CrossOrigin
public class DoctorController {
	
    @Autowired
	private DoctorRepository Dcrepo;
    

	//all doctors 
	//http://localhost:7075/pdms/doctorcontroller/getalldoctor
	@GetMapping("/getalldoctor")
	public List<Doctor> getAllDoctor() {
		return Dcrepo.findAll();  
	} 
	
	//find by doctor username
	//http://localhost:7075/pdms/doctorcontroller/getdoctorbyusername
    @GetMapping("/getdoctorbyusername/{doctorobject}")
    public Doctor getbyusernamedoctor(@PathVariable(value="doctorobject") String doctorobject)
    {
    	return   Dcrepo.findByUsername(doctorobject); 
    }
	
	
	//doctor check 
	//http://localhost:7075/pdms/doctorcontroller/doctorlogin
	@PostMapping("/doctorlogin")
    public Boolean  doctorlogin(@Validated @RequestBody Doctor doctor) 
    {
        Boolean a=false;;
        String name=doctor.getUsername();
        String password=doctor.getPassword();
        Doctor b = Dcrepo.findByUsername(name);
        if(b==null) {
        	return a;
        }
        if(name.equals(b.getUsername()) && password.equals(b.getPassword()))
                {
            a=true;
           
                }
        return a;
    }

	
	//post doctor by id 
	//http://localhost:7075/pdms/doctorcontroller/deletedoctorbyid
    @PostMapping("/deletedoctorbyid")
    public String deletedoctor(@Validated @RequestBody Doctor doctorobj)
       throws ResourceNotFoundException
    {
    	Doctor doctor =Dcrepo.findById(doctorobj.getDoctorId()).
    			orElseThrow(() -> new ResourceNotFoundException 
    			("doctor Not Found for this Id: "+ String.valueOf( doctorobj.getDoctorId())));
    	
    	Dcrepo.delete(doctor);
    	
    	
    	return "deleted"; 
    }
	
	
	
} 




