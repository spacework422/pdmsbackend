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

import com.pdms.model.Appointment;
import com.pdms.repository.AppointmentRepository;
//import com.hospital.exception.ResourceNotFoundException; 
  
@RestController
@RequestMapping("/appointmentcontroller")
@CrossOrigin
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository arepo;
	
	//Get - 
	//http://localhost:7075/hospital/appointmentcontroller/getallppointment
	@GetMapping("/getallppointment")
	public List<Appointment> getAllappointment() {
		return arepo.findAll(); 
	} 
	
	//POST - 
	//http://localhost:7075/hospital/appointmentcontroller/appointmentregister
	@PostMapping("/appointmentregister")
    public Appointment saveappointment(@Validated @RequestBody Appointment appointment) {
     return arepo.save(appointment); 
                    
	}

} 




