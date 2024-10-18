package com.main.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dto.UserRequest;
import com.main.dto.UserRolePremissionRequest;
import com.main.dto.UserRoleRequest;
import com.main.entity.UserEntity;
import com.main.entity.UserRole;

@Component
public class UserTranslator {
	@Autowired
	private ObjectMapper mapper;

	public UserTranslator(ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}
	
	public UserEntity toentity(UserRequest request) {
		return mapper.convertValue(request, UserEntity.class);
	}
	
	public UserRole toRoleEntity(UserRoleRequest request) {
		return mapper.convertValue(request, UserRole.class);
	}
	
	public UserRolePremissionRequest toentitypremission(UserRolePremissionRequest premissionRequest) {
		return mapper.convertValue(premissionRequest, UserRolePremissionRequest.class);
	}
}
