package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.dto.UserRequest;
import com.main.entity.UserEntity;
import com.main.repository.UserRepository;
import com.main.translator.UserTranslator;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
public class UserService {

	@Autowired
	private UserTranslator translator;
	
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public String createUser(UserRequest request) {
		log.info("here user srevice are run and save the user");
		UserEntity user = translator.toentity(request);
		repository.save(user);
		return "create Successfully";
	}
}
