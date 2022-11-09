package com.pdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdms.model.Healthreport; 
import com.pdms.repository.HealthreportRepository; 
import com.pdms.exception.ResourceNotFoundException; 
  
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
	
	//update the healthrecort
	//http://localhost:7075/pdms/healthreportrepository/healthrecordupdate/{}
	@PutMapping("/healthrecordupdate/{id}")
    public ResponseEntity<Healthreport> healthrecordupdate(@PathVariable(value="id") Integer recordid,
    		@Validated @RequestBody Healthreport receivedhealthrecord) throws ResourceNotFoundException
    {
		Healthreport healthreport=arepo.findById(recordid).
    			orElseThrow(() -> new ResourceNotFoundException
    			("Product Not Found for this Id: " +String.valueOf(recordid)));
				 healthreport.setDoctorprescption(receivedhealthrecord.getDoctorprescption());
		         healthreport.setDoctorverified(true);
    			    			
    			final Healthreport updatedhealthreport=arepo.save(healthreport);
    			
    			return ResponseEntity.ok(updatedhealthreport);
    }
	
	//POST - 
	//http://localhost:7075/pdms/healthreportrepository/healthreportregister
	@PostMapping("/healthreportregister")
    public Healthreport saveappointment(@Validated @RequestBody Healthreport healthreport) {
     return arepo.save(healthreport); 
                    
	}

} 




