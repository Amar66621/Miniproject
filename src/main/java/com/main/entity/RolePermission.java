package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class RolePermission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean delete;
	private boolean isDefaultLandingPage;
	private int moduleId;
	private boolean read;
	private int subModuleIds;
	private boolean update;
	private boolean write;
	
	// welcome to my profile

}
