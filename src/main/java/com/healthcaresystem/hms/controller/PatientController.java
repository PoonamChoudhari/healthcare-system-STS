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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.healthcaresystem.hms.model.Patient;
import com.healthcaresystem.hms.service.PatientService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@PostMapping("/registerPatient")
	public ResponseEntity<Object> registerPatient(@RequestBody Patient patient) {
		String tempEmailId = patient.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			Patient patientObj = patientService.findByEmailId(tempEmailId);
			if(patientObj != null) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "User with email Id is already exist.");
			}
		}
		
		Patient patientObj = null;
		patientObj = patientService.addOrUpdatePatient(patient);
		Map<String, Object> responseEntity = new HashMap<>();
		responseEntity.put("data", patientObj);
		responseEntity.put("status", HttpStatus.OK);
		
		return new ResponseEntity<Object>(responseEntity,HttpStatus.OK);
	}
	
	@PostMapping("/patientLogin")
	public ResponseEntity<Object> patientLogin(@RequestBody Patient patient) throws Exception {
		String tempEmail = patient.getEmailId();
		String tempPass = patient.getPassword();
		Patient patientObj = null;
		if(tempEmail != null && tempPass != null) {
			patientObj = patientService.fetchPatientByEmailAndPassword(tempEmail, tempPass);
		}
		System.out.println(patientObj);
		if(patientObj == null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Bad Credentials.");
		}
		
			Map<String, Object> responseEntity = new HashMap<>();
			responseEntity.put("message","Success" );
			responseEntity.put("data", patientObj);
			return new ResponseEntity<Object>(responseEntity,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addOrUpdatePatient(patient);
	}
	
	@PutMapping("/updatePatientByDoctor/patientId/{patientId}/doctorId/{doctorId}")
	public ResponseEntity<Object> updatePatientByDoctor(@PathVariable long patientId, @PathVariable long doctorId){
		Integer value = patientService.updatePatientByDoctor(patientId, doctorId);
		Map<String, Object> responseEntity = new HashMap<>();
		responseEntity.put("status",value);
		return new ResponseEntity<Object>(responseEntity, HttpStatus.OK);
	}
	
	@PutMapping("/updatePatientProfile/{patientId}")
	public ResponseEntity<Patient> updatePatientProfile(@RequestBody Patient patient, @PathVariable long patientId){
			return new ResponseEntity<Patient>(patientService.updatePatient(patient, patientId), HttpStatus.OK);
	}

}
