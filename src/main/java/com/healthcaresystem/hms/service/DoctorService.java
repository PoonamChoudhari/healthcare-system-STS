package com.healthcaresystem.hms.service;

import java.util.List;

import com.healthcaresystem.hms.model.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor findByEmailId(String emailId);
	Doctor fetchDoctorByEmailAndPassword(String emailId, String password);
	Doctor findDoctorById(long doctorId);
	Doctor updateDoctor(Doctor doctor, long doctorId);
	List<Doctor> findDoctorBySpeciality(String speciality);
	Doctor updateSlotAvailability(Doctor doctor, long doctorId);
}
