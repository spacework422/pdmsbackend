package com.pdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdms.model.Pharmacist;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Integer> {

	public Pharmacist findByName(String name);

}
