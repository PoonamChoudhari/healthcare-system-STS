package com.healthcaresystem.hms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "doctors",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    })
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
	
	@Column(name="description", nullable = true)
	private String description;
	
	@Column(name="mobile")
	private long phone_number;
	
	@Column(name="year_experience")
	private long yearOfExperience;
	
	@Column(name="gender")
	private int gender;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="role")
	private int role;
	
	@Column(name="consultation_fees")
	private long consultation_fees;
	
	@Column(name="start_time", nullable = true)
	private String start_time;
	
	@Column(name="end_time", nullable = true)
	private String end_time;
				
	
	@Column(name="visit_duration", nullable = true)
	private String visit_duration;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Clinic clinic;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="dId", referencedColumnName = "doctorId")
	private List<Patient> patients;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="appointment_dId", referencedColumnName = "doctorId")
	private List<Appointment> appoitments;
}
