package com.pdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdms.model.Doctor;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Integer> {

	public Doctor findByUsername(String name);

	
}
