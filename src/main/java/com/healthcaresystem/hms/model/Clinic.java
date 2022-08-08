package com.healthcaresystem.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="clinics")
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clinicId;
	
	@Column(name="clinic_name")
	private String clinicName;
	
	@Column(name="address")
	private String address;
	
}
