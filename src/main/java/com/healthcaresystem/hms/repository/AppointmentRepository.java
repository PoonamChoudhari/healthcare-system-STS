package com.healthcaresystem.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.healthcaresystem.hms.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	@Query("SELECT a from Appointment a WHERE " +
			"a.appointment_dId=:doctorId")
	List<Appointment> findAppointmentsByDoctorId(long doctorId);
}
