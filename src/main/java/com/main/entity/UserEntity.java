package com.main.entity;




import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private int roleId;
	private int status;
	private String userEmail;
	private String userRole;
	private String password;

	  @OneToMany(targetEntity = UserRole.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	   @JoinColumn(name = "role_id", referencedColumnName = "id")
	private List<UserRole> roles;

	
	


}
