package com.jspiders.hibernate.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="fbuserinfo")
public class FaceBookUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String name;
	@Column(nullable = false, unique = false)
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Post> posts;
}
