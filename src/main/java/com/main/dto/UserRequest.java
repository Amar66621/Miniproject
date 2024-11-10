package com.main.dto;




import lombok.Data;

@Data
public class UserRequest {

	private String firstName;
	private String lastName;
	private String phoneNo;
	private int status;
	private String userEmail;
	private String userRole;
	private String password;
	
}
