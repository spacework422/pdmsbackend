package com.pdms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdms.model.Pharmacist; 
import com.pdms.repository.PharmacistRepository;
   
@RestController
@RequestMapping("/pharmacistcontroller")
@CrossOrigin
public class PharmacistController {
	
	@Autowired
	private PharmacistRepository phrepo;
	
	//Get - 
	//http://localhost:7075/hospital/appointmentcontroller/getallppointment
//	@GetMapping("/getallppointment")
//	public List<Appointment> getAllappointment() {
//		return arepo.findAll(); 
//	} 
	
	//POST - 
	//http://localhost:7075/hospital/pharmacistcontroller/pharmacistregister
	@PostMapping("/pharmacistregister")
    public Pharmacist savepharmacist(@Validated @RequestBody Pharmacist pharmacist) {
     return phrepo.save(pharmacist); 
                    
	}

} 




