package com.healthcaresystem.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcaresystem.hms.exception.ResourceNotFoundException;
import com.healthcaresystem.hms.model.Patient;
import com.healthcaresystem.hms.repository.PatientRepository;
import com.healthcaresystem.hms.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	public PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient addOrUpdatePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findByEmailId(String emailId) {
		return patientRepository.findByEmailId(emailId);
	}

	@Override
	public Patient fetchPatientByEmailAndPassword(String emailId, String password) {
		return patientRepository.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public Integer updatePatientByDoctor(long patientId, long doctorId) {
		return patientRepository.updatePatientByDoctor(patientId, doctorId);
	}

	@Override
	public Patient updatePatient(Patient patient, long patientId) {
		Patient existingPatient = patientRepository.findById(patientId).orElseThrow(
				() -> new ResourceNotFoundException("Patient", "patientid", patientId));
		
		existingPatient.setPatientName(patient.getPatientName());
		existingPatient.setAddress(patient.getAddress());
		existingPatient.setAge(patient.getAge());
		existingPatient.setPhone_number(patient.getPhone_number());
		
		patientRepository.save(existingPatient);
		return existingPatient;
	}
}
