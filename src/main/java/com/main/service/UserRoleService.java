package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.main.dto.UserRoleRequest;

import com.main.entity.UserRole;
import com.main.repository.UserRoleReository;
import com.main.translator.UserTranslator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRoleService {

	@Autowired
	private  UserRoleReository repository;
	
	@Autowired
	private UserTranslator translator;
	
	public ResponseEntity<String> createUserRole(UserRoleRequest request){
		log.info("Here user Role are created and save in the database");
		UserRole entity = translator.toRoleEntity(request);
		UserRole role = repository.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body("UserRole created");
		
	}
}
