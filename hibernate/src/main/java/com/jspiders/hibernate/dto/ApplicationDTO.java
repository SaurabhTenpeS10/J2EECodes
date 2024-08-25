package com.jspiders.hibernate.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "applicationinfo")
public class ApplicationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, unique = false)
    private String name;
    
    @Column(nullable = false, unique = false)
    private double size;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "application_mobile",
        joinColumns = @JoinColumn(name = "application_id"),
        inverseJoinColumns = @JoinColumn(name = "mobile_id")
    )
    private List<MobileDTO> mobileDTOs;
}