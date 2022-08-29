package com.healthcaresystem.hms.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcaresystem.hms.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	Patient findByEmailId(String emailId);
	Patient findByEmailIdAndPassword(String emailId, String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE Patient SET d_id =:doctorId WHERE patient_id =:patientId")
	Integer updatePatientByDoctor(@Param("patientId") long patientId, @Param("doctorId") long doctorId);
}
