package com.pdms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdms.exception.ResourceNotFoundException;
import com.pdms.model.Admin;
import com.pdms.model.Doctor;
import com.pdms.model.Pharmacist;
import com.pdms.repository.AdminRepository;
import com.pdms.repository.DoctorRepository;
import com.pdms.repository.PharmacistRepository;

  
@RestController
@RequestMapping("/admincontroller")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminRepository Adrepo;
	
	@Autowired
	private DoctorRepository Dcrepo;
	
	@Autowired 
	private PharmacistRepository Phrepo;
	
	//doctor registration post
	//http://localhost:7075/pdms/admincontroller/doctorregistration
	@PostMapping("/doctorregistration")
    public Doctor doctorregistration(@Validated @RequestBody Doctor doctor) { 
         return Dcrepo.save(doctor);                  
	}
	//all doctors 
	//http://localhost:7075/pdms/admincontroller/getalldoctor
	@GetMapping("/getalldoctor")
	public List<Doctor> getAllDoctor() {
		return Dcrepo.findAll();  
	} 
	
	//all pharma 
	//http://localhost:7075/pdms/admincontroller/getallpharma
	@GetMapping("/getallpharma")
	public List<Pharmacist> getallpharma() {
		return Phrepo.findAll();  
	} 
	
	//post doctor by id 
	//http://localhost:7075/pdms/admincontroller/deletedoctorbyid
    @PostMapping("/deletedoctorbyid")
    public List<Doctor> deletedoctor(@Validated @RequestBody Doctor doctorobj)
       throws ResourceNotFoundException
    {
    	Doctor doctor =Dcrepo.findById(doctorobj.getDoctorId()).
    			orElseThrow(() -> new ResourceNotFoundException 
    			("doctor Not Found for this Id: "+ String.valueOf( doctorobj.getDoctorId())));
    	
    	Dcrepo.delete(doctor);
    	return Dcrepo.findAll(); 
    }
    
    //post pharma delete
   // http://localhost:7075/pdms/admincontroller/deletepharmabyid
    @PostMapping("/deletepharmabyid")
    public List<Pharmacist> deletedoctor(@Validated @RequestBody Pharmacist pharmacistobj)
       throws ResourceNotFoundException
    {
    	Pharmacist pharmacist =Phrepo.findById(pharmacistobj.getPharmaId()).
    			orElseThrow(() -> new ResourceNotFoundException 
    			("pharmasist Not Found for this Id: "+ String.valueOf( pharmacistobj.getPharmaId())));
    	
    	Phrepo.delete(pharmacist);
    	return Phrepo.findAll(); 
    }
	
	
	//Pharmacist registration post
	//http://localhost:7075/pdms/admincontroller/pharmaregistration
	@PostMapping("/pharmaregistration")
    public Pharmacist pharmaregistration(@Validated @RequestBody Pharmacist pharmacist) { 
         return Phrepo.save(pharmacist);                   
	}
	
	//Admin registration post
	//http://localhost:7075/pdms/admincontroller/adminregister
	@PostMapping("/adminregister")
    public Admin adminregister(@Validated @RequestBody Admin admin) { 
         return Adrepo.save(admin);                   
	}
	
	//Admin login  
	//http://localhost:7075/pdms/admincontroller/Adminlogin
	@PostMapping("/Adminlogin")
    public Boolean Adminlogin(@Validated @RequestBody Admin admin) 
    {
        Boolean a=false;;
        String name=admin.getUsername();
        String password=admin.getPassword();
        Admin b = Adrepo.findByUsername(name);
        if(b==null) {
        	return a;
        }
        if(name.equals(b.getName()) && password.equals(b.getPassword()))
                {
            a=true;
           
                }
        return a;
    }
	
	//pharma login check
	//http://localhost:7075/pdms/admincontroller/pharmalogin
	@PostMapping("/pharmalogin")
    public Boolean pharmalogin(@Validated @RequestBody Pharmacist pharmacist) 
    {
        Boolean a=false;;
        String name=pharmacist.getName();
        String password=pharmacist.getPassword();
        Pharmacist b = Phrepo.findByName(name);   
        if(b==null) {
        	return a;
        }
        if(name.equals(b.getName()) && password.equals(b.getPassword()))
                {
            a=true;
           
                }
        return a;
    }
//	//Get - 
//	//http://localhost:7075/hospital/pharmacontroller/getpharma
//	@GetMapping("/getpharma")
//	public List<Pharma> getAllProducts() {
//		return prepo.findAll();  
//	} 
//	
//	//POST - 
//	//http://localhost:7075/hospital/pharmacontroller/pharmaregister
//	@PostMapping("/pharmaregister")
//    public Pharma saveProduct(@Validated @RequestBody Pharma pharma) {
//     return prepo.save(pharma);
//                    
//	}
//	
//	//Get By ID - 
//	//http://localhost:7075/hospital/pharmacontroller/getbyid/{id}
//	@GetMapping("/getbyid/{id}")
//    public ResponseEntity<Pharma> getProductById(@PathVariable(value="id") Integer pId)
//    		throws ResourceNotFoundException
//    		{
//		Pharma pharma =prepo.findById(pId).  //findById()  method is predefined in jpa in build
//    			         orElseThrow(() -> new ResourceNotFoundException
//    			          ("Pharma  Not Found for this Id: "+ String.valueOf(pId)));
//    	             
//    	             return ResponseEntity.ok().body(pharma);     
//    		}
//	
//	//Post verify user id
//	//http://localhost:7075/hospital/pharmacontroller/pharmalogin
//	   @PostMapping("/pharmalogin")
//	    public Boolean loginUser(@Validated @RequestBody Pharma pharma) 
//	    {
//	        Boolean a=false;;
//	        String name=pharma.getName();
//	        String password=pharma.getPassword();
//	        Pharma b = prepo.findByName(name);
//	        if(b==null) {
//	        	return a;
//	        }
//	        if(name.equals(b.getName()) && password.equals(b.getPassword()))
//	                {
//	            a=true;
//	           
//	                }
//	        return a;
//	    }

} 




