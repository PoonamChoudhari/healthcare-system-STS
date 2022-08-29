package com.healthcaresystem.hms.service;

import java.util.List;

import com.healthcaresystem.hms.model.Patient;

public interface PatientService {
	
	Patient addOrUpdatePatient(Patient patient);
	List<Patient> getAllPatients();
	Patient findByEmailId(String emailId);
	Patient fetchPatientByEmailAndPassword(String emailId, String password);
	Integer updatePatientByDoctor(long patientId, long doctorId); 
	Patient updatePatient(Patient patient, long patientId);
}
