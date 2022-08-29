package com.healthcaresystem.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthcaresystem.hms.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	Doctor findByEmailId(String emailId);
	Doctor findByEmailIdAndPassword(String emailId, String password);
	
	@Query("SELECT d from Doctor d WHERE " +
			"d.speciality LIKE CONCAT('%',:speciality, '%')")
	List<Doctor> findDoctorBySpeciality(String speciality);
}
