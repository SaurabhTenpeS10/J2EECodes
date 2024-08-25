package com.jspiders.hibernate.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="collegeinfo")
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = false)
	private String collegeName;
	@Column(nullable = false, unique = false)
	private String location;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "colleges")
	List<Student> students;
	
}
