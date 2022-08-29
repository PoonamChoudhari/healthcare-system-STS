package com.healthcaresystem.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcaresystem.hms.exception.ResourceNotFoundException;
import com.healthcaresystem.hms.model.Doctor;
import com.healthcaresystem.hms.repository.DoctorRepository;
import com.healthcaresystem.hms.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	private DoctorRepository doctorRepository;

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor findByEmailId(String emailId) {
		return doctorRepository.findByEmailId(emailId);
	}

	@Override
	public Doctor fetchDoctorByEmailAndPassword(String emailId, String password) {
		return doctorRepository.findByEmailIdAndPassword(emailId, password);
	}

	@Override
	public Doctor findDoctorById(long doctorId) {
		return doctorRepository.findById(doctorId).get();
	}

	@Override
	public Doctor updateDoctor(Doctor doctor, long doctorId) {
		Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(
				() -> new ResourceNotFoundException("Doctor", "doctorId", doctorId));
		
		existingDoctor.setDoctorName(doctor.getDoctorName());
		existingDoctor.setAddress(doctor.getAddress());
		existingDoctor.setClinic(doctor.getClinic());
		existingDoctor.setConsultation_fees(doctor.getConsultation_fees());
		existingDoctor.setDegree(doctor.getDegree());
		existingDoctor.setPhone_number(doctor.getPhone_number());
		existingDoctor.setSpeciality(doctor.getSpeciality());
		existingDoctor.setYearOfExperience(doctor.getYearOfExperience());
		
		doctorRepository.save(existingDoctor);
		return existingDoctor;
	}

	@Override
	public List<Doctor> findDoctorBySpeciality(String speciality) {
		List<Doctor> doctors = doctorRepository.findDoctorBySpeciality(speciality);
		return doctors;
	}

	@Override
	public Doctor updateSlotAvailability(Doctor doctor, long doctorId) {
		Doctor existingDoctor = doctorRepository.findById(doctorId).orElseThrow(
				() -> new ResourceNotFoundException("Doctor", "doctorId", doctorId));
		
		existingDoctor.setStart_time(doctor.getStart_time());
		existingDoctor.setEnd_time(doctor.getEnd_time());
		existingDoctor.setVisit_duration(doctor.getVisit_duration());
		
		doctorRepository.save(existingDoctor);
		return existingDoctor;
	}

}
