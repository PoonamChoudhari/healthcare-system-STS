package com.healthcaresystem.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
