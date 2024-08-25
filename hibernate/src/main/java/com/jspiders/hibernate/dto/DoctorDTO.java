package com.jspiders.hibernate.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="doctorinformation")
public class DoctorDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String name;
	@Column(nullable = false, unique=false)
	private String speciality;
	@ManyToMany
	private List<PatientDTO> patientDTOs;
	
}
