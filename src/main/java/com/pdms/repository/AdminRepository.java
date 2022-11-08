package com.pdms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdms.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByUsername(String name);

}
