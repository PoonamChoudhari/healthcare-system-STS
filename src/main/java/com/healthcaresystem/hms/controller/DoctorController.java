package com.healthcaresystem.hms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@PostMapping("/registerDoctor")
	public ResponseEntity<Object> registerDoctor(@RequestBody Doctor doctor) {
		String tempEmailId = doctor.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			Doctor doctorObj = doctorService.findByEmailId(tempEmailId);
			if(doctorObj != null) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User with email Id is already exist.");
			}
		}
		
		Doctor doctorObj = null;
		doctorObj = doctorService.saveDoctor(doctor);
		Map<String, Object> responseEntity = new HashMap<>();
		responseEntity.put("data", doctorObj);
		responseEntity.put("status", HttpStatus.OK);
		
		return new ResponseEntity<Object>(responseEntity,HttpStatus.OK);
	}
	
	@PostMapping("/doctorLogin")
	public ResponseEntity<Object> doctorLogin(@RequestBody Doctor doctor) {
		String tempEmail = doctor.getEmailId();
		String tempPass = doctor.getPassword();
		Doctor doctorObj = null;
		if(tempEmail != null && tempPass != null) {
			doctorObj = doctorService.fetchDoctorByEmailAndPassword(tempEmail, tempPass);
		}
		if(doctorObj == null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Bad Credentials.");
		}
		
			Map<String, Object> responseEntity = new HashMap<>();
			responseEntity.put("message","Success" );
			responseEntity.put("data", doctorObj);
			return new ResponseEntity<Object>(responseEntity,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateDoctorProfile/{doctorId}")
	public ResponseEntity<Doctor> updateDoctorProfile(@RequestBody Doctor doctor, @PathVariable long doctorId){
			return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor, doctorId), HttpStatus.OK);
	}

	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/getDoctorById/{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable long doctorId) {
		Doctor doctorObj = doctorService.findDoctorById(doctorId);
		return new ResponseEntity<Doctor>(doctorObj, HttpStatus.OK);
		
	}
	
	@GetMapping("/findDoctorBySpeciality")
	public ResponseEntity<List<Doctor>> findDoctorBySpeciality(@RequestParam("speciality") String speciality){
		
		return ResponseEntity.ok(doctorService.findDoctorBySpeciality(speciality));
		
	}
	
	@PutMapping("/updateSlotAvailability/{doctorId}")
	public ResponseEntity<Doctor> updateSlotAvailability(@PathVariable long doctorId, @RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.updateSlotAvailability(doctor, doctorId), HttpStatus.OK);
	}
	
	
}
