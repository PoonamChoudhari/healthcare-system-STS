package com.healthcaresystem.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcaresystem.hms.model.Doctor;
import com.healthcaresystem.hms.service.DoctorService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DoctorController {
	
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}

	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
}
