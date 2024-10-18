package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "role_id", nullable = false)
	    private UserRole role;
}
