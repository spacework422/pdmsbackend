package com.pdms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdms.model.Healthreport; 


@Repository
public interface HealthreportRepository extends JpaRepository<Healthreport, Integer>{
	
//	public Doctor findByName(String name);
//	public List<Doctor> findByStream(String stream);
//	public List<Doctor> findByHospital(String Hospital);

}

