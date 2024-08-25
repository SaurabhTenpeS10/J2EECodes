package com.jspiders.hibernate.dto;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "mobileinfo")
public class MobileDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = false)
    private String brand;
    
    @Column(nullable = false, unique = false)
    private String apk;
    
    @ManyToMany(mappedBy = "mobileDTOs", cascade = CascadeType.ALL)
    private List<ApplicationDTO> applicationDTOs;
}