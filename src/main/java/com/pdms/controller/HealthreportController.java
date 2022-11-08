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

import com.pdms.model.Healthreport; 
import com.pdms.repository.HealthreportRepository; 
//import com.hospital.exception.ResourceNotFoundException; 
  
@RestController
@RequestMapping("/healthreportrepository")
@CrossOrigin
public class HealthreportController {
	
	@Autowired
	private HealthreportRepository arepo;
	
	//Get - 
	//http://localhost:7075/pdms/healthreportrepository/getallhealthreport
	@GetMapping("/getallhealthreport")
	public List<Healthreport> getAllappointment() {
		return arepo.findAll(); 
	} 
	
	//POST - 
	//http://localhost:7075/pdms/healthreportrepository/healthreportregister
	@PostMapping("/healthreportregister")
    public Healthreport saveappointment(@Validated @RequestBody Healthreport healthreport) {
     return arepo.save(healthreport); 
                    
	}

} 




