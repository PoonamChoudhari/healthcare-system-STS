package com.healthcaresystem.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthcaresystem.hms.model.Appointment;
import com.healthcaresystem.hms.repository.AppointmentRepository;
import com.healthcaresystem.hms.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	private AppointmentRepository appointmentRepository;
	

	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> findAppointmentsByDoctorId(long doctorId) {
		return appointmentRepository.findAppointmentsByDoctorId(doctorId);
	}

}
