package com.healthcaresystem.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcaresystem.hms.model.Appointment;
import com.healthcaresystem.hms.service.AppointmentService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/bookAppointment")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(appointmentService.createAppointment(appointment), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAppointmentsByDoctorId/{doctorId}")
	public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable long doctorId){
		return ResponseEntity.ok(appointmentService.findAppointmentsByDoctorId(doctorId));
	}

}
