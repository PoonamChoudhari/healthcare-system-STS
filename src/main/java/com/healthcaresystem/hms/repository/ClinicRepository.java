package com.healthcaresystem.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcaresystem.hms.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
	

}
