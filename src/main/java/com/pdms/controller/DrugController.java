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

import com.pdms.model.Drug;
import com.pdms.repository.DrugRepository;
import com.pdms.exception.ResourceNotFoundException;
 
  
@RestController
@RequestMapping("/drugcontroller")
@CrossOrigin
public class DrugController {
	
    @Autowired
	private DrugRepository Drrepo;
    
    //post of drug
    //http://localhost:7075/pdms/drugcontroller/drugregistration
	@PostMapping("/drugregistration")
    public Drug doctorregistration(@Validated @RequestBody Drug drug) { 
         return Drrepo.save(drug);                  
	}
	
	//all drugs 
	//http://localhost:7075/pdms/drugcontroller/getalldrugs
	@GetMapping("/getalldrugs")
	public List<Drug> getAlldrugs() {
		return Drrepo.findAll();  
	} 
	
	//find by id 
	//http://localhost:7075/pdms/drugcontroller/drugbyid/{2}
    @GetMapping("/drugbyid/{id}")
    public ResponseEntity<Drug> drugbyid(@PathVariable(value="id") Integer drid)
    		throws ResourceNotFoundException
    		{
    					Drug drug =Drrepo.findById(drid).  
    			         orElseThrow(() -> new ResourceNotFoundException
    			          ("drug Not Found for this Id: "+String.valueOf(drid)));
    	             
    	             return ResponseEntity.ok().body(drug);     
    		}
    
    
    //order status putt 
    //http://localhost:7075/pdms/drugcontroller/orderstatus
	@PutMapping("/orderstatus/{id}")
    public ResponseEntity<Drug> updatedrug(@PathVariable(value="id") Integer drid,
    		@Validated @RequestBody Drug d) throws ResourceNotFoundException
    {
		Drug drug=Drrepo.findById(drid).
    			orElseThrow(() -> new ResourceNotFoundException
    			("drug Not Found for this Id: " +String.valueOf(drid)));
    			drug.setOrderstatus(d.getOrderstatus());
			
    			
    			final Drug updatedrug=Drrepo.save(drug);
    			
    			return ResponseEntity.ok(updatedrug);
    }

		
} 




