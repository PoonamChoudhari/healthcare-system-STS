package com.healthcaresystem.hms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="speciality")
	private String speciality;
	
	@Column(name="address")
	private String address;
	
	@Column(name="degree_name")
	private String degree;
	
	@Column(name="description")
	private String description;
	
	@Column(name="year_experience")
	private long yearOfExperience;
	
	@Column(name="consultation_fees")
	private long consultation_fees;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Clinic clinic;
	
}
