package com.pdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdms.model.Drug;

@Repository
public interface DrugRepository  extends JpaRepository<Drug, Integer> {

	public Drug findByPname(String name);
	public Drug findByPhaname(String name);

	
}

