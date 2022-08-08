package com.healthcaresystem.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcaresystem.hms.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
