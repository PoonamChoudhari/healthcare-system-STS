package com.healthcaresystem.hms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appointmentId;
	
	@Column(name="start_time")
	private String start_time;
	
	@Column(name="end_time")
	private String end_time;
	
	@Column(name="appointment_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date appointment_date;
	
	@Column(name="visit_duration")
	private String visit_duration;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="appointment_dId")
	private long appointment_dId;
	
	@Column(name="appointment_pId")
	private long appointment_pId;

}
