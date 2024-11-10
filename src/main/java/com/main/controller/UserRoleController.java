package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.UserRoleRequest;
import com.main.service.UserRoleService;

@RestController
@RequestMapping("/role")
public class UserRoleController {
	
	@Autowired
	private UserRoleService service;
	
	
	@PostMapping("/save")
	public ResponseEntity<String> Save(@RequestBody UserRoleRequest request){
		return service.createUserRole(request);
	}

}
