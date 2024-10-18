package com.main.dto;
import java.util.Set;

import lombok.Data;

@Data
public class UserRequest {

	private String firstName;
	private String lastName;
	private String phoneNo;
	private Set<Long> roleIds;
	private int status;
	private String userEmail;
	private String userRole;
	private String password;
	
	
}
