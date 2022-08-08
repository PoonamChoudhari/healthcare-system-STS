package com.healthcaresystem.hms.service;

import java.util.List;

import com.healthcaresystem.hms.model.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
}
