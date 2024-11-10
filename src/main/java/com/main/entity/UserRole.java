package com.main.entity;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean canAccessMobileRequest;
	private boolean canAccessWebRequest;
	private String roleDescription;
	private String roleName;
	private int status;
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	
private UserEntity entity;

	
	

}
