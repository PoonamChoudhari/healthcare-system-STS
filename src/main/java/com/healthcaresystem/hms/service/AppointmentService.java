package com.healthcaresystem.hms.service;

import java.util.List;

import com.healthcaresystem.hms.model.Appointment;

public interface AppointmentService {
	
	Appointment createAppointment(Appointment appointment);
	List<Appointment> findAppointmentsByDoctorId(long doctorId);
}
