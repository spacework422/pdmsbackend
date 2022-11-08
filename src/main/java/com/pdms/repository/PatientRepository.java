package com.pdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdms.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	public Patient findByName(String name);
}
