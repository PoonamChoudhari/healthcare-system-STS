package com.healthcaresystem.hms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "patient",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientId;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="email")
	private String emailId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="mobile")
	private String phone_number;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gender")
	private int gender;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private int role;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="appointment_pId", referencedColumnName = "patientId")
	private List<Appointment> appoitments;
	
}
